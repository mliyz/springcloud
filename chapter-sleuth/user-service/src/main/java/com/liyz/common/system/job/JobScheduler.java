package com.liyz.common.system.job;

import com.liyz.common.system.ioc.SpringContextUtil;
import com.liyz.common.system.util.SpringKafkaConsumer;
import com.liyz.common.system.util.SpringKafkaProducerSync;
import com.yixin.common.utils.JobConstant;
import com.yixin.common.utils.JobParamDTO;
import com.yixin.common.utils.JobResultDTO;
import com.yixin.common.utils.JobStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 任务调度Kafka
 *
 * Package : com.yixin.common.system.job
 *
 * @author YixinCapital -- wujt 2016年8月12日 上午9:13:02
 *
 */
public class JobScheduler implements ApplicationListener<ContextRefreshedEvent> {

	private ConcurrentMap<String, String> localMap = new ConcurrentHashMap<>();

	private ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 100, 2 * 3600 * 1000,
			TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

	private final Logger logger = LoggerFactory.getLogger(JobScheduler.class);

	private String groupName;

	private String projectName;

	private boolean initFlag = true;

	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * 启动监听
	 *
	 * @param event
	 * @author YixinCapital -- wujt 2017年5月23日 上午11:34:54
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 避免改成五层框架后两次调用
		if (SpringContextUtil.getApplicationContext() != null && initFlag) {
			logger.info("init JobScheduler begin!!!");
			SpringKafkaConsumer.startKafkaInboundChannel(groupName, JobConstant.JOB_RECEIVE_TOPIC,
					new JobMessageListener(), true);
			logger.info("init JobScheduler success!!!");
		}

	}

	@SuppressWarnings("rawtypes")
	class JobMessageListener implements AcknowledgingMessageListener {
		@Override
		public void onMessage(Object data, Acknowledgment ack) {
			try {
				ConsumerRecord record = (ConsumerRecord) data;
				String message = (String) record.value();
				JobResultDTO resultDTO = parseMessage(message);
				if (resultDTO != null) {
					String projectKey = resultDTO.getProjectKey();
					String recordId = resultDTO.getRecordId();
					logger.info("1.RecordId [{}]_kafka: Got projectKey:[{}] from Kafka!", recordId,
							projectKey);
					String re = localMap.get(recordId);
					if (StringUtils.isNotBlank(re)) {
						logger.info("2.RecordId [{}]_kafka: Handling projectKey:[{}]....", recordId,
								projectKey);
					} else {
						localMap.put(recordId, recordId);
						// 是当前系统的任务时，执行此任务
						if (projectName.equals(projectKey)) {
							logger.info("3.RecordId [{}]_kafka:Start execute job :{}", recordId,
									resultDTO.getJobKey());
							start(resultDTO);
							Future<JobResultDTO> submit = executor
									.submit(new DealMessage(resultDTO));
							logger.info("5.RecordId [{}]_kafka:Deal projectKey:[{}] success!",
									recordId, projectKey);
						}
					}
				} else {
					logger.info("6.RecordId [{}]_kafka:从 kafka 消息队列 [{}] 接收到的消息不符合标准，舍弃：{}",
							JobConstant.JOB_RECEIVE_TOPIC, message);
				}
			} catch (Exception e) {
				logger.info("7.RecordId [{}]_kafka:========消息处理失败==========", e);
			} finally {
				ack.acknowledge();
			}
		}
	}

	class DealMessage implements Callable<JobResultDTO> {
		JobResultDTO resultDTO;

		public DealMessage(JobResultDTO resultDTO) {

			this.resultDTO = resultDTO;
		}

		public JobResultDTO getResultDTO() {
			return resultDTO;
		}

		public void setResultDTO(JobResultDTO resultDTO) {
			this.resultDTO = resultDTO;
		}

		@Override
		public JobResultDTO call() throws Exception {
			return execute(resultDTO, 3);
		}

	}

	/**
	 * 用反射的执行定时任务
	 *
	 * @param resultDTO
	 * @return
	 * @author YixinCapital -- wujt 2016年8月15日 上午10:58:52
	 */
	private JobResultDTO execute(JobResultDTO resultDTO, int retries) {
		try {
			logger.info("execute0.RecordId [{}]_kafka: come in execute...!",
					resultDTO.getRecordId());
			String jobKey = resultDTO.getJobKey();
			if (StringUtils.isNotBlank(jobKey)) {
				logger.info("execute1.RecordId [{}]_kafka: Start execute...!",
						resultDTO.getRecordId());
				Class<?> clazz = Class.forName(jobKey);
				JobParamDTO paramDTO = new JobParamDTO();
				paramDTO.setAgrs(resultDTO.getAgrs());
				// 先从spring容器中取
				JobExecutor instance = null;
				try {
					instance = (JobExecutor) SpringContextUtil.getApplicationContext()
							.getBean(clazz);
				} catch (Exception e) {
					logger.error(
							"execute2.RecordId [{}]_kafka:getInstance from springfactory has error",
							resultDTO.getRecordId(), e);
					resultDTO.setStatus(JobStatus.execute_exception.getIndex());
				}
				if (instance != null) {
					logger.info("execute3.RecordId [{}]_kafka:execute job ：" + resultDTO.getJobKey()
							+ " start ...", resultDTO.getRecordId());
					paramDTO = instance.execute(paramDTO);
					resultDTO.setResultCode(paramDTO.getResultCode());
					resultDTO.setResultContent(paramDTO.getResultContent());
					resultDTO.setRetryFlag(paramDTO.isRetryFlag());
					resultDTO.setStatus(paramDTO.getStatus());
					logger.info("execute4.RecordId [{}]_kafka:execute job ：" + resultDTO.getJobKey()
							+ " end !!!", resultDTO.getRecordId());
				}
			}
		} catch (Exception e) {
			logger.error("execute5.RecordId [{}]_kafka:execute job ：" + resultDTO.getJobKey()
					+ " has errors:", resultDTO.getRecordId(), e);
			resultDTO.setStatus(JobStatus.execute_exception.getIndex());
		} finally {
			if (resultDTO != null) {
				if (resultDTO.isRetryFlag() && retries > 0) { // 是否重发
					int t = retries - 1;
					resultDTO = execute(resultDTO, t); // 重新执行
				} else { // 无需再次执行时，发送消息给调度中心
					resultDTO.setEndExecuteTime(new Date());
					sendToKafka(resultDTO);
				}
			}
			localMap.remove(resultDTO.getRecordId());
		}
		return resultDTO;
	}

	/**
	 * 解析参数
	 *
	 * @param message
	 * @return
	 * @author YixinCapital -- wujt 2016年8月15日 上午10:58:35
	 */
	private JobResultDTO parseMessage(String message) throws IOException {
		return mapper.readValue(message, JobResultDTO.class);
	}

	/**
	 * 开始执行时调用
	 *
	 * @author YixinCapital -- wujt 2016年8月12日 上午9:46:52
	 */
	public void start(JobResultDTO jobResultDTO) {
		if (jobResultDTO != null) {
			jobResultDTO.setStartExecuteTime(new Date());
			jobResultDTO.setStatus(JobStatus.executing.getIndex());
			sendToKafka(jobResultDTO);
			logger.info("4.RecordId [{}]_kafka:Send startStatus to kafka success!",
					jobResultDTO.getRecordId());
		}
	}

	/**
	 * 结束后调用
	 *
	 * @author YixinCapital -- wujt 2016年8月12日 上午9:46:52
	 */
	public void end(JobResultDTO jobResultDTO, int retries) {
		if (jobResultDTO != null) {
			if (jobResultDTO.isRetryFlag() && retries > 0) { // 是否重发
				jobResultDTO = execute(jobResultDTO, 3); // 重新执行
				int t = retries - 1;
				end(jobResultDTO, t); // 判断是否还需再次执行
			} else { // 无需再次执行时，发送消息给调度中心
				jobResultDTO.setEndExecuteTime(new Date());
				sendToKafka(jobResultDTO);
			}
		}
	}

	private void sendToKafka(JobResultDTO jobResultDTO) {
		String message = null;
		try {
			message = mapper.writeValueAsString(jobResultDTO);
		} catch (Exception e) {
			logger.error("RecordId [{}]_kafka:transform jobResultDTO to json has error:",
					jobResultDTO.getRecordId(), e);
		}
		if (message != null) {
			SpringKafkaProducerSync.send(JobConstant.JOB_SEND_TOPIC, message);
			logger.info("RecordId [{}]_kafka:send message[{}]to [" + JobConstant.JOB_SEND_TOPIC
					+ "] sucess!", jobResultDTO.getRecordId(), message);
		}
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public Logger getLogger() {
		return logger;
	}

	public boolean isInitFlag() {
		return initFlag;
	}

	public void setInitFlag(boolean initFlag) {
		this.initFlag = initFlag;
	}

}
