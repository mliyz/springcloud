package com.liyz.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.HostAndPort;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("redisClientUtil")
public class RedisClientUtil {
	protected final static Logger logger = LoggerFactory.getLogger(RedisClientUtil.class);
	private JedisCluster jedisCluster;
	private RedisTools handle;
	@Value("${spring.redis.cluster.nodes}")
	private String redisServers;

	@PostConstruct
	public void init() {
		logger.info("Init Redis Service : " + redisServers);
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		for (String server : redisServers.split(",")) {
			jedisClusterNodes.add(new HostAndPort(server.split(":")[0], Integer.parseInt(server.split(":")[1])));
		}
		jedisCluster = new JedisCluster(jedisClusterNodes);
		handle = new RedisTools(jedisCluster);
		logger.info("Init Redis Service sucess!");
	}

	@PreDestroy
	public void close() throws IOException {
		jedisCluster.close();
	}

	/**
	 * 根据key获取数据
	 *
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return handle.get(key, "");
	}
	
	
	/**
	 * 存入数据
	 *
	 * @param key
	 * @param value
	 */
	public void set(String key,String value){
		handle.set(key, value);
	}
	
	/**
	 * 判断key是否存在
	 *
	 * @param key
	 */
	public boolean exist(String key){
		return handle.exist(key);
	}
	
	/**
	 * 根据key删除
	 *
	 * @param key
	 */
	public boolean del(String key){
		return handle.del(key);
	}

	/**
	 * 添加一个Key对应的Value
     *
	 * @param key
     * @param value
     * @param second
     * @return
	 */
	public boolean set(String key, String value, int second) {
		jedisCluster.setex(key, second, value);
		return true;
	}

	public boolean setnx(String key, String value, int second) {
		Long l = jedisCluster.setnx(key,value);
		if(l==1){
			jedisCluster.expire(key,second);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 *
	 * @Description: 对可以加有效时间，当不存在key的时候返回false
	 * @param key
	 * @param second
	 * @return boolean
	 * @throws
	 */
	public boolean expire(String key, int second) {
		if(exist(key)){
			jedisCluster.expire(key,second);
			return true;
		}
		
		return false;
	}

	public String hmset(String key, Map<String, String> hash) {
		String result = jedisCluster.hmset(key, hash);
		return result;
	}

	public String hget(String key,String field){
		String result = jedisCluster.hget(key, field);
		return result;
	}

	public Object eval(String script, List<String> keys, List<String> args){
		return jedisCluster.eval(script,keys,args);
	}
	/**
	 * 给当前key对应的value值+1后并返回结果，如果不存在该key则设置该key并将值设置为0并进行+1后返回结果
	 * @param key
	 * @param timeOut 设置过期时间
	 * @return
	 */
	public synchronized long incr(String key,int timeOut){
		long num = jedisCluster.incr(key);
		jedisCluster.expire(key, timeOut);
		return num;
	}
	/**
	 * 给当前key对应的value值+1后并返回结果，如果不存在该key则设置该key并将值设置为0并进行+1后返回结果
	 * @param key
	 * @return
	 */
	public long incr(String key){
		return jedisCluster.incr(key);
	}
	/**
	 * 对指定的key对应的值-1后返回结果，如果不存在该key则设置该key并将值设置为0并进行-1后返回结果
	 * @param key
	 * @param timeOut 设置过期时间
	 * @return
	 */
	public synchronized long decr(String key,int timeOut){
		long num = jedisCluster.decr(key);
		jedisCluster.expire(key, timeOut);
		return num;
	}
	/**
	 * 对指定的key对应的值-1后返回结果，如果不存在该key则设置该key并将值设置为0并进行-1后返回结果
	 * @param key
	 * @return
	 */
	public long decr(String key){
		return jedisCluster.decr(key);
	}
}