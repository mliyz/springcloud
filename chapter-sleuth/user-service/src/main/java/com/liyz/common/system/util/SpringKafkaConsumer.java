package com.liyz.common.system.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer.AckMode;
import org.springframework.kafka.listener.KafkaDataListener;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * kafka 消费者 Package : com.yixin.common.system.util
 *
 * @author YixinCapital -- zhuq 2016年11月29日 下午3:54:32
 * @see https://github.com/spring-projects/spring-integration-kafka 2.1.0.RELEASE
 * @See http://192.168.145.20/index.php/Spring-integration-kafka#2.2.E7.94.9F.E4.BA.A7.E8.80.85
 */
public class SpringKafkaConsumer {

    private SpringKafkaConsumer() {
    }

    private final static String KAFKA_INBOUND_PROPERTIS = "META-INF/props/kafka-inbound.properties";
    private final static String KAFKA_CONFIG_KEY_GROUPID = "group.id";
    private final static String ENABLE_AUTO_COMMIT = "enable.auto.commit";
    private final static Logger logger = LoggerFactory.getLogger(SpringKafkaConsumer.class);
    private static Map<String, KafkaMessageListenerContainer<Integer, String>> containers;
    private static Properties shareProperties;
    static {
        containers = new ConcurrentHashMap<String, KafkaMessageListenerContainer<Integer, String>>();
        shareProperties = new Properties();
        InputStream input = null;
        input = Thread.currentThread().getContextClassLoader().getResourceAsStream(KAFKA_INBOUND_PROPERTIS);
        try {
            shareProperties.load(input);
        } catch (IOException e) {
            logger.error("start KafkaInbound failed", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error("start KafkaInbound failed", e);
                }
            }
        }
    }

    /**
     * 启动kafka消费者
     *
     * @param groupId
     * @see https://kafka.apache.org/documentation
     * @param topic
     * @param messageListener
     *            当selfAck为true时，KafkaDataListener用AcknowledgingMessageListener
     * @param selfAck
     *            是否手动commit
     * @author YixinCapital -- zhuq 2016年11月30日 下午1:52:10
     */
    public static void startKafkaInboundChannel(String groupId, String topic, KafkaDataListener messageListener,
            boolean... selfAck) {
        if (StringUtils.isBlank(groupId) || StringUtils.isBlank(topic) || messageListener == null) {
            logger.error("parameters is null,groupId:" + groupId + ",topic:" + topic + ",messageListener:"
                    + messageListener);
            return;
        }
        final String key = groupId + topic + messageListener.getClass().getName();
        KafkaMessageListenerContainer<Integer, String> container = containers.get(key);
        if (container == null) {
            synchronized (SpringKafkaConsumer.class) {
                container = containers.get(key);
                if (container == null) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    for (final String name : shareProperties.stringPropertyNames()) {
                        map.put(name, shareProperties.getProperty(name));
                    }
                    map.put(KAFKA_CONFIG_KEY_GROUPID, groupId);
                    ContainerProperties containerProps = new ContainerProperties(topic);
                    // 采用手工确认必须使用实现AcknowledgingMessageListener接口的类通过acknowledgment.acknowledge()来确认消费
                    if (selfAck != null && selfAck.length > 0 && selfAck[0]) {
                        containerProps.setAckMode(AckMode.MANUAL_IMMEDIATE);
                        map.put(ENABLE_AUTO_COMMIT, false);
                    }
                    DefaultKafkaConsumerFactory<Integer, String> cf = new DefaultKafkaConsumerFactory<Integer, String>(
                            map);
                    container = new KafkaMessageListenerContainer<>(cf, containerProps);
                    container.setupMessageListener(messageListener);
                    logger.info("Initialized a new kafka consumer,groupId:" + groupId + ",topic:" + topic
                            + ",messageListener:" + messageListener.getClass().getName());
                    container.start();
                    containers.put(key, container);
                }
            }
        }
    }

    /**
     * 停止Kafka消费
     *
     * @param
     * @return
     * @author YixinCapital--wujt 2017/7/10 11:22
     *
     */
    public static void stopKafkaConsumer() {
        logger.info("Stoping kafka containers...");
        for (KafkaMessageListenerContainer<Integer, String> container : containers.values()) {
            logger.info("Stop kafka container:{}", container.getContainerProperties());
            container.stop();
            containers.remove(container);
        }
        logger.info("All containers stoped!");
    }

}
