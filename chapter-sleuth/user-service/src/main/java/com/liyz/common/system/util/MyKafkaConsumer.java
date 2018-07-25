package com.liyz.common.system.util;

/**
 *  kafka consumer
 *
 * Package : com.yixin.common.system.utils
 *
 * @author YixinCapital -- wujt
 *		   2016年4月11日 下午4:40:36
 *
 */
@Deprecated
public class MyKafkaConsumer {

    /*  private Logger logger = LoggerFactory.getLogger(MyKafkaConsumer.class);
      private ConsumerConnector consumerConnector;

      public MyKafkaConsumer(String groupId, String zookeeperAddress) {
          logger.info("start create MykafkaConsumer:groupId=" + groupId + ";zookeeperAddress=" + zookeeperAddress);
          Properties properties = new Properties();
          properties.put("zookeeper.connect", zookeeperAddress);
          properties.put("auto.commit.enable", "true");
          properties.put("auto.commit.interval.ms", "600000");
          properties.put("group.id", groupId);
          ConsumerConfig consumerConfig = new ConsumerConfig(properties);
          consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
          logger.info("create MykafkaConsumer:groupId=" + groupId + ";zookeeperAddress=" + zookeeperAddress
                  + " SUCCESSED!");
      }

      public ConsumerConnector getConsumerConnector() {
          return consumerConnector;
      }*/
}
