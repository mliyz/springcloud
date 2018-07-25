package com.liyz.common.system.util;

/**
 * 系统配置类
 *
 * Package : com.yixin.system.utils
 *
 * @author YixinCapital -- wujt
 *		   2016年4月11日 下午4:19:20
 *
 */
public class CustomConfiguration {

    /**
     * zookeeper地址
     */
    private String zookeeperAddress;

    /**
     * redis地址
     */
    private String redisServers;
    /**
     * kafka地址
     */
    private String kafkaServers;

    public String getZookeeperAddress() {
        return zookeeperAddress;
    }

    public void setZookeeperAddress(String zookeeperAddress) {
        this.zookeeperAddress = zookeeperAddress;
    }

    public String getRedisServers() {
        return redisServers;
    }

    public void setRedisServers(String redisServers) {
        this.redisServers = redisServers;
    }

    public String getKafkaServers() {
        return kafkaServers;
    }

    public void setKafkaServers(String kafkaServers) {
        this.kafkaServers = kafkaServers;
    }

}
