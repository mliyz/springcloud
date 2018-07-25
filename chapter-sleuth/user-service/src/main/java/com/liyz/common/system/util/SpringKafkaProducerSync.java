package com.liyz.common.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * kafka 生产者 同步发送消息 Package : com.yixin.common.system.util
 *
 * @author YixinCapital -- zhuq 2016年11月30日 下午5:06:01
 * @see https://github.com/spring-projects/spring-integration-kafka 2.1.0.RELEASE
 * @See http://192.168.145.20/index.php/Spring-integration-kafka#2.2.E7.94.9F.E4.BA.A7.E8.80.85
 */
public class SpringKafkaProducerSync {

	private SpringKafkaProducerSync() {
	}

	private final static String KAFKA_OUTBOUND_PROPERTIS = "META-INF/props/kafka-outbound.properties";
	private final static Logger logger = LoggerFactory.getLogger(SpringKafkaProducerSync.class);
	private static KafkaProducerMessageHandler<Integer, String> handler;
	private static Properties shareProperties;
	static {
		shareProperties = new Properties();
		InputStream input = null;
		input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(KAFKA_OUTBOUND_PROPERTIS);
		try {
			shareProperties.load(input);
		} catch (IOException e) {
			logger.error("start KafkaOutbound failed", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("start KafkaOutbound failed", e);
				}
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		for (final String name : shareProperties.stringPropertyNames()) {
			map.put(name, shareProperties.getProperty(name));
		}
		ProducerFactory<Integer, String> producerFactory = new DefaultKafkaProducerFactory<>(map);
		KafkaTemplate<Integer, String> template = new KafkaTemplate<>(producerFactory);
		handler = new KafkaProducerMessageHandler<>(template);
		handler.setSync(true);
		handler.afterPropertiesSet();
	}

	/**
	 * 同步发送消息
	 *
	 * @param topic
	 *            主题
	 * @param message
	 *            消息内容
	 * @author YixinCapital -- zhuq 2016年11月30日 下午5:16:39
	 */
	public static void send(String topic, String message) {
		Message<?> msg = MessageBuilder.withPayload(message).setHeader(KafkaHeaders.TOPIC, topic)
				.build();
		handler.handleMessage(msg);
	}
}
