package com.liyz.common.system.util;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.liyz.common.system.ioc.InstanceFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.core.task.TaskExecutor;

import java.util.Collection;
import java.util.Properties;

/**
 * kafka producer
 *
 * Package : com.yixin.system.utils
 *
 * @author YixinCapital -- wujt 2016年4月11日 下午4:40:47
 *
 */
@Deprecated
public class MyKafkaProducer {

    private Producer<String, String> producer;

    private TaskExecutor taskExecutor;

    private CustomConfiguration customConfiguration;

    private Logger logger = LoggerFactory.getLogger(MyKafkaProducer.class);

    public MyKafkaProducer() {
        this.customConfiguration = InstanceFactory.getInstance(CustomConfiguration.class);
        Properties props = new Properties();
        logger.info("MyKafkaProducer init begin!" + this.customConfiguration.getKafkaServers());
        props.put("bootstrap.servers", this.customConfiguration.getKafkaServers());
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        setProducer(new KafkaProducer<String, String>(props));
        logger.info("MyKafkaProducer init successfully!");

    }

    // 处理消息的内部类
    class SendMessage implements Runnable {
        private String topicName;
        private String message;

        SendMessage(String topicName, String message) {
            this.topicName = topicName;
            this.message = message;
        }

        @Override
        public void run() {
            logger.info(topicName + "======" + message);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, message);
            getProducer().send(record);
        }
    }

    /**
     * 异步发送单条数据
     *
     * @param topicName
     * @param message
     * @author YixinCapital -- wujt 2016年4月1日 下午2:40:23
     */
    public void send(String topicName, String message) {
        if (topicName == null || message == null) {
            return;
        }
        logger.debug(String.format("发送消息[%s]到[%s]", message, topicName));
        taskExecutor.execute(new SendMessage(topicName, message));
    }

    /**
     * 异步发送多条数据
     *
     * @param topicName
     * @param messages
     * @author YixinCapital -- wujt 2016年4月1日 下午2:41:29
     */
    public void send(String topicName, Collection<String> messages) {
        if (topicName == null || messages == null) {
            return;
        }
        if (messages.isEmpty()) {
            return;
        }
        for (String message : messages) {
            taskExecutor.execute(new SendMessage(topicName, message));
        }
    }

    /**
     * 同步发送单条数据
     *
     * @param topicName
     * @param message
     * @author YixinCapital -- wujt 2016年4月1日 下午2:40:23
     */
    public void sendSync(String topicName, String message) {
        if (topicName == null || message == null) {
            return;
        }
        logger.debug(String.format("发送消息[%s]到[%s]", message, topicName));
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, message);
        getProducer().send(record);
    }

    /**
     * 同步发送多条数据
     *
     * @param topicName
     * @param messages
     * @author YixinCapital -- wujt 2016年4月1日 下午2:41:29
     */
    public void sendSync(String topicName, Collection<String> messages) {
        if (topicName == null || messages == null) {
            return;
        }
        if (messages.isEmpty()) {
            return;
        }
        for (String message : messages) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, message);
            getProducer().send(record);
        }
    }

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void close() {
        getProducer().close();
    }

    public Producer<String, String> getProducer() {
        return producer;
    }

    public void setProducer(Producer<String, String> producer) {
        this.producer = producer;
    }

    public CustomConfiguration getCustomConfiguration() {
        return customConfiguration;
    }

    public void setCustomConfiguration(CustomConfiguration customConfiguration) {
        this.customConfiguration = customConfiguration;
    }

}
