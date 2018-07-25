package com.liyz.common.system.job;

import com.liyz.common.system.ioc.SpringContextUtil;
import com.rabbitmq.client.*;
import com.yixin.common.utils.JobConstant;
import com.yixin.common.utils.JobParamDTO;
import com.yixin.common.utils.JobResultDTO;
import com.yixin.common.utils.JobStatus;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.netty.util.internal.ThreadLocalBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;

/**
 * 任务调度RabbitMQ
 *
 * Package : com.yixin.common.system.job
 *
 * @author YixinCapital -- wujt 2016年8月12日 上午9:13:02
 *
 */
public class JobSchedulerRabbit implements ApplicationListener<ContextRefreshedEvent> {

	private ConcurrentMap<String, String> localMap = new ConcurrentHashMap<>();

	private ThreadPoolTaskExecutor jobExecutor;

	private final Logger logger = LoggerFactory.getLogger(JobSchedulerRabbit.class);

	private String projectName;

	private String username;

	private String password;

	private String addresses;

	private boolean initFlag = true;

	private ObjectMapper mapper = new ObjectMapper();

	private Connection connection;

	private ThreadLocal<Boolean> init = new ThreadLocalBoolean();

	/**
	 * 启动监听
	 *
	 * @param event
	 * @author YixinCapital -- wujt 2017年5月23日 上午11:34:54
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (!init.get() && SpringContextUtil.getApplicationContext() != null && initFlag) {
			init.set(true);
			logger.info("init rabbitMQ JobScheduler begin!!!");
			ConnectionFactory factory = new ConnectionFactory();
			factory.setVirtualHost(JobConstant.VIRTUALHOST);
			factory.setUsername(username);
			factory.setPassword(password);
			List<Address> ads = new ArrayList<>();
			String[] address = addresses.split(",");
			for (int i = 0; i < address.length; i++) {
				String[] split = address[i].split(":");
				ads.add(new Address(split[0], Integer.valueOf(split[1])));
			}
			try {
				connection = factory.newConnection(ads);
				final Channel channel = connection.createChannel();
				channel.exchangeDeclare(JobConstant.EXCHANGERECEIVE + "." + projectName,
						BuiltinExchangeType.DIRECT, true);

				channel.queueDeclare(JobConstant.JOB_RECEIVE_TOPIC + "." + projectName, true, false,
						false, null);

				channel.queueBind(JobConstant.JOB_RECEIVE_TOPIC + "." + projectName,
						JobConstant.EXCHANGERECEIVE + "." + projectName,
						JobConstant.ROUTINGKEYRECEIV + "." + projectName);

				channel.basicQos(1);

				final Consumer consumer = new DefaultConsumer(channel) {
					@Override
					public void handleDelivery(String consumerTag, Envelope envelope,
							AMQP.BasicProperties properties, byte[] body) throws IOException {
						String message = new String(body, "UTF-8");
						logger.info("RecordId_rabbitMQ:RabbitMQ Received [{}] message:{}",
								envelope.getRoutingKey(), message);
						try {
							handleMessage(message);
						} catch (Exception e) {
							logger.error("RecordId_rabbitMQ:handle message append exception", e);
						} finally {
							channel.basicAck(envelope.getDeliveryTag(), false); // ack !!!
						}
					}
				};
				boolean autoAck = false; // ack !!!
				channel.basicConsume(JobConstant.JOB_RECEIVE_TOPIC + "." + projectName, autoAck,
						consumer);
				logger.info("init rabbitMQ JobScheduler success!!!");

			} catch (Exception e1) {
				logger.error("init rabbitMQ had error!!!!!!!", e1);
			}
		}

	}

	public void handleMessage(String message) {
		JobResultDTO resultDTO = parseMessage(message);
		if (resultDTO != null) {
			String projectKey = resultDTO.getProjectKey();
			String recordId = resultDTO.getRecordId();
			logger.info("1.RecordId [{}]_rabbitMQ:Getted projectKey:{}", recordId, projectKey);
			String re = localMap.get(recordId);
			if (StringUtils.isNotBlank(re)) {
				logger.info("2.RecordId [{}]_rabbitMQ:Handling projectKey:{}....", recordId,
						projectKey);
			} else {
				localMap.put(recordId, recordId);
				if (projectName.equals(projectKey)) { // 是当前系统的任务时，执行此任务
					logger.info("3.RecordId [{}]_rabbitMQ:start execute job :{}", recordId,
							resultDTO.getJobKey());
					start(resultDTO);
					logger.info("RecordId [{}]_rabbitMQ: current executor activeCount: {}",
							recordId, jobExecutor.getActiveCount());
					logger.info("RecordId [{}]_rabbitMQ: current executor CorePoolSize: {} ",
							recordId, jobExecutor.getCorePoolSize());
					logger.info("RecordId [{}]_rabbitMQ: current executor PoolSize: {} ", recordId,
							jobExecutor.getPoolSize());
					Future<JobResultDTO> submit = jobExecutor.submit(new DealMessage(resultDTO));
					logger.info("5.RecordId [{}]_rabbitMQ:Deal projectKey:{} success!", recordId,
							projectKey);
				}
			}
		} else {
			logger.info("6.RecordId_rabbitMQ:从 {} 接收到的消息不符合标准，舍弃：{}", JobConstant.JOB_RECEIVE_TOPIC,
					message);
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
			logger.info("RecordId[{}]_rabbitMQ: start call method...", resultDTO.getRecordId());
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
			logger.info("execute0.RecordId [{}]_rabbitMQ: come in execute...!",
					resultDTO.getRecordId());
			String jobKey = resultDTO.getJobKey();
			if (StringUtils.isNotBlank(jobKey)) {
				logger.info("execute1.RecordId [{}]_rabbitMQ: Start execute...!",
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
							"execute2.RecordId [{}]_rabbitMQ:getInstance from springfactory has error",
							resultDTO.getRecordId(), e);
					resultDTO.setStatus(JobStatus.execute_exception.getIndex());
				}
				if (instance == null) {
					instance = (JobExecutor) clazz.newInstance();
				}
				if (instance != null) {
					logger.info("execute3.RecordId [{}]_rabbitMQ:execute job ："
							+ resultDTO.getJobKey() + " start ...", resultDTO.getRecordId());
					paramDTO = instance.execute(paramDTO);
					resultDTO.setResultCode(paramDTO.getResultCode());
					resultDTO.setResultContent(paramDTO.getResultContent());
					resultDTO.setRetryFlag(paramDTO.isRetryFlag());
					resultDTO.setStatus(paramDTO.getStatus());
					logger.info("execute4.RecordId [{}]_rabbitMQ:execute job ："
							+ resultDTO.getJobKey() + " end !!!", resultDTO.getRecordId());
				}
			}
		} catch (Exception e) {
			logger.error("execute5.RecordId [{}]_rabbitMQ:execute job ：" + resultDTO.getJobKey()
					+ " has errors:", resultDTO.getRecordId(), e);
			resultDTO.setStatus(JobStatus.execute_exception.getIndex());
		} finally {
			if (resultDTO != null) {
				if (resultDTO.isRetryFlag() && retries > 0) { // 是否重发
					int t = retries - 1;
					resultDTO = execute(resultDTO, t); // 重新执行
				} else { // 无需再次执行时，发送消息给调度中心
					resultDTO.setEndExecuteTime(new Date());
					sendToRabbitMQ(resultDTO);
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
	private JobResultDTO parseMessage(String message) {
		JobResultDTO resultDTO = null;
		try {
			resultDTO = mapper.readValue(message, JobResultDTO.class);
		} catch (Exception e) {
			logger.error("parse Message to JobResultDTO error!");
		}
		return resultDTO;
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
			sendToRabbitMQ(jobResultDTO);
			logger.info("4.RecordId [{}]_rabbitMQ:send startStatus projectKey:{} success!",
					jobResultDTO.getRecordId(), jobResultDTO.getJobKey());
		}
	}

	private void sendToRabbitMQ(JobResultDTO jobResultDTO) {
		String message = null;
		try {
			message = mapper.writeValueAsString(jobResultDTO);
		} catch (Exception e) {
			logger.error("RecordId [{}]_rabbitMQ:transform jobResultDTO to json has error:",
					jobResultDTO.getRecordId(), e);
		}
		if (message != null) {
			Channel channel = null;
			try {
				channel = connection.createChannel();

				channel.exchangeDeclare(JobConstant.EXCHANGESEND, BuiltinExchangeType.DIRECT, true);

				channel.basicPublish(JobConstant.EXCHANGESEND, JobConstant.ROUTINGKEYSEND, null,
						message.getBytes("UTF-8"));
				logger.info(String.format("RecordId [{}]_rabbitMQ:[%s] sent message: %s",
						jobResultDTO.getRecordId(), JobConstant.EXCHANGESEND, message));
			} catch (Exception e) {
				logger.error("RecordId [{}]_rabbitMQ:send message to rabbitMQ error！",
						jobResultDTO.getRecordId(), e);
			} finally {
				if (channel != null) {
					try {
						channel.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			logger.info("RecordId [{}]_rabbitMQ:send message {} to " + JobConstant.JOB_SEND_TOPIC
					+ " sucess!", jobResultDTO.getRecordId(), message);
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
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

	public ThreadPoolTaskExecutor getJobExecutor() {
		return jobExecutor;
	}

	public void setJobExecutor(ThreadPoolTaskExecutor jobExecutor) {
		this.jobExecutor = jobExecutor;
	}
}
