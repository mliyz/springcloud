package com.liyz.common.system.util;

import com.rabbitmq.client.*;
import com.yixin.basemessage.dto.BaseMessageContent;
import com.yixin.basemessage.dto.inform.YxInformMessage;
import com.yixin.basemessage.dto.mail.YxMailMessage;
import com.yixin.basemessage.dto.msg.YxPushMessage;
import com.yixin.basemessage.dto.sms.YxSmsMessage;
import com.yixin.basemessage.utils.YxMessageType;
import com.yixin.common.utils.JsonObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * description: 发送消息的基础工具类 com.yixin.common.system.util.BaseMessageUtil
 *
 * @author wujt
 * @date 2016/12/26
 */
public class BaseMessageUtil {

	private static final Logger logger = LoggerFactory.getLogger(BaseMessageUtil.class);

	private BaseMessageUtil() {
	}

	public static final String PATTERN = "\"type\":{0},\"data\":{1},\"ext\":null";
	private final static String RABBITMQ_PROPERTIS = "META-INF/props/rabbitmq.properties";
	private static Properties rabbitmqProperties;
	private static Connection connection;

	static {
		rabbitmqProperties = new Properties();
		InputStream input = null;
		input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(RABBITMQ_PROPERTIS);
		try {
			rabbitmqProperties.load(input);
		} catch (IOException e) {
			logger.error("start rabbitmq failed", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("start rabbitmq failed", e);
				}
			}
		}
	}

	private static void initBaseMessageUtil() {
		if (connection == null) {
			logger.info("init rabbitMQ Message begin!!!");
			ConnectionFactory factory = new ConnectionFactory();
			factory.setVirtualHost(BaseMessageContent.VIRTUALHOST);
			factory.setUsername(rabbitmqProperties.getProperty("rabbitmq.username"));
			factory.setPassword(rabbitmqProperties.getProperty("rabbitmq.password"));
			List<Address> ads = new ArrayList<>();
			String[] address = rabbitmqProperties.getProperty("rabbitmq.addresses").split(",");
			for (int i = 0; i < address.length; i++) {
				String[] split = address[i].split(":");
				ads.add(new Address(split[0], Integer.valueOf(split[1])));
			}
			try {
				connection = factory.newConnection(ads);
				logger.info("init rabbitMQ Message success!!!");
			} catch (Exception e1) {
				logger.error("init Message had error!!!!!!!", e1);
			}
		}
	}

	private static void sendToRabbitMQ(String message) {
		if (message != null) {
			initBaseMessageUtil();
			Channel channel = null;
			try {
				channel = connection.createChannel();

				channel.exchangeDeclare(BaseMessageContent.EXCHANGESEND, BuiltinExchangeType.DIRECT,
						true);

				channel.basicPublish(BaseMessageContent.EXCHANGESEND,
						BaseMessageContent.ROUTINGKEYSEND, null, message.getBytes("UTF-8"));
				logger.info(String.format("Message  rabbitMQ:[%s] sent message: %s",
						BaseMessageContent.EXCHANGESEND, message));
			} catch (Exception e) {
				logger.error("Message rabbitMQ:send message to rabbitMQ error！", message, e);
			} finally {
				if (channel != null) {
					try {
						channel.close();
					} catch (Exception e) {
						logger.error("Message rabbitMQ: close channel has error！", e);
					}
				}
			}
		}
	}

	/**
	 * 发送短信
	 */
	public static void sendSMS(YxSmsMessage smsMessage) {
		// SpringKafkaProducerSync.send(BaseMessageContent.MESSAGETOPIC,
		// "{" + MessageFormat.format(PATTERN, YxMessageType.MESSAGE.getCode(),
		// JsonObjectUtils.objectToJson(smsMessage)) + "}");

		if (smsMessage == null || smsMessage.getChannelType() == null
				|| StringUtils.isBlank(smsMessage.getContent())
				|| StringUtils.isBlank(smsMessage.getMobile())) {
			throw new RuntimeException("短信信息封装不正确");
		}

		sendToRabbitMQ("{" + MessageFormat.format(PATTERN, YxMessageType.MESSAGE.getCode(),
				JsonObjectUtils.objectToJson(smsMessage)) + "}");
	}

	/**
	 * 发送邮件
	 */
	public static void sendMail(YxMailMessage mailMessage) {
		if (mailMessage == null || StringUtils.isBlank(mailMessage.getMailSubject())
				|| StringUtils.isBlank(mailMessage.getMailTo())
				|| StringUtils.isBlank(mailMessage.getMailText())) {
			throw new RuntimeException("邮件信息封装不正确");
		}
		sendToRabbitMQ("{" + MessageFormat.format(PATTERN, YxMessageType.MAIL.getCode(),
				JsonObjectUtils.objectToJson(mailMessage)) + "}");
	}

	/**
	 * APP消息推送
	 */
	public static void sendAppMessage(YxPushMessage pushMessage) {
		sendToRabbitMQ("{" + MessageFormat.format(PATTERN, YxMessageType.PUSH.getCode(),
				JsonObjectUtils.objectToJson(pushMessage)) + "}");
	}

	/**
	 * 发送portal消息通知
	 */
	public static void sendNoticeMessage(YxInformMessage pushMessage) {
		sendToRabbitMQ("{" + MessageFormat.format(PATTERN, YxMessageType.NOTICE.getCode(),
				JsonObjectUtils.objectToJson(pushMessage)) + "}");
	}

}
