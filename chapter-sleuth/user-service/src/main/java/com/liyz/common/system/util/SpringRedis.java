package com.liyz.common.system.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;

/**
 *
 * 集成Spring-data-redis
 *
 */
@Configuration
public class SpringRedis {

    private final static Logger logger = LoggerFactory.getLogger(SpringRedis.class);
    private final static String REDIS_PROPERTIES_PATH = "META-INF/props/rediscluster.properties";
    private static ResourcePropertySource redisClusterPropertySource = null;

    static {
        try {
            redisClusterPropertySource = new ResourcePropertySource(REDIS_PROPERTIES_PATH,
                    SpringRedis.class.getClassLoader());
        } catch (IOException e) {
            logger.error("redis configuration failed because could not load from " + REDIS_PROPERTIES_PATH, e);
            throw new RuntimeException("redis configuration failed because could not load from "
                    + REDIS_PROPERTIES_PATH);
        }
    }

    @Bean
    JedisConnectionFactory jedisRedisClusterConnectionFactory() {
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisClusterPropertySource);
        JedisConnectionFactory factory = new JedisConnectionFactory(redisClusterConfiguration);
        return factory;
    }

    /**
     * 可用于Redis Cluster环境
     * {@link RedisClusterConfiguration}
     *
     * @return
     * @author YixinCapital -- zhuq
     *	       2016年11月29日 上午11:28:03
     */
    @Bean
    StringRedisTemplate stringRedisClusterTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisRedisClusterConnectionFactory());
        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }

}
