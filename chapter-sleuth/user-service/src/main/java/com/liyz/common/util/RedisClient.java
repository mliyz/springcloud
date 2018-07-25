package com.liyz.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author YixinCapital -- ${user}
 *         ${date} ${time}
 */
public class RedisClient {

    public String get(String key) {
        Jedis jedis = this.getJedis();
        String value = jedis.get(key);
        this.closeJedis(jedis);
        return value;
    }

    public byte[] get(byte[] key) {
        Jedis jedis = this.getJedis();
        byte[] value = jedis.get(key);
        this.closeJedis(jedis);
        return value;
    }

    public String get(String key, String field) {
        Jedis jedis = this.getJedis();
        String value = jedis.hget(key, field);
        this.closeJedis(jedis);
        return value;
    }

    public byte[] get(byte[] key, byte[] field) {
        Jedis jedis = this.getJedis();
        byte[] value = jedis.hget(key, field);
        this.closeJedis(jedis);
        return value;
    }

    public void del(String key) {
        Jedis jedis = this.getJedis();
        jedis.del(key);
        this.closeJedis(jedis);
    }

    public void del(byte[] key) {
        Jedis jedis = this.getJedis();
        jedis.del(key);
        this.closeJedis(jedis);
    }

    public void del(String key, String field) {
        Jedis jedis = this.getJedis();
        jedis.hdel(key, field);
        this.closeJedis(jedis);
    }

    public void del(byte[] key, byte[] field) {
        Jedis jedis = this.getJedis();
        jedis.hdel(key, field);
        this.closeJedis(jedis);
    }

    public Map<String,String> hgetAll(String key) {
        Jedis jedis = this.getJedis();
        Map<String,String> value = jedis.hgetAll(key);
        this.closeJedis(jedis);
        return value;
    }

    public Map hgetAll(byte[] key) {
        Jedis jedis = this.getJedis();
        Map value = jedis.hgetAll(key);
        this.closeJedis(jedis);
        return value;
    }

    public long hset(String key, String field, String value) {
        Jedis jedis = this.getJedis();
        long result = jedis.hset(key, field, value);
        this.closeJedis(jedis);
        return result;
    }

    public String hmset(String key, Map<String, String> hash) {
        Jedis jedis = this.getJedis();
        String result = jedis.hmset(key, hash);
        this.closeJedis(jedis);
        return result;
    }

    public void put(String key, String value) {
        Jedis jedis = this.getJedis();
        jedis.set(key, value);
        this.closeJedis(jedis);
    }

    public void put(byte[] key, byte[] value) {
        Jedis jedis = this.getJedis();
        jedis.set(key, value);
        this.closeJedis(jedis);
    }


    public void put(String key, String value, int seconds) {
        Jedis jedis = this.getJedis();
        jedis.set(key, value);
        jedis.expire(key, seconds);
        this.closeJedis(jedis);
    }

    public void put(byte[] key, byte[] value, int seconds) {
        Jedis jedis = this.getJedis();
        jedis.set(key, value);
        jedis.expire(key, seconds);
        this.closeJedis(jedis);
    }

    public void put(String key, Map map) {
        Jedis jedis = this.getJedis();
        jedis.hmset(key, map);
        this.closeJedis(jedis);
    }

    public void put(String key, Map map, int seconds) {
        Jedis jedis = this.getJedis();
        jedis.hmset(key, map);
        jedis.expire(key, seconds);
        this.closeJedis(jedis);
    }

    public void put(String key, String field, String value) {
        Jedis jedis = this.getJedis();
        jedis.hset(key, field, value);
        this.closeJedis(jedis);
    }

    public void put(byte[] key, byte[] field, byte[] value) {
        Jedis jedis = this.getJedis();
        jedis.hset(key, field, value);
        this.closeJedis(jedis);
    }

    public void put(byte[] key, byte[] field, byte[] value, int seconds) {
        Jedis jedis = this.getJedis();
        jedis.hset(key, field, value);
        jedis.expire(key, seconds);
        this.closeJedis(jedis);
    }

    public boolean exists(String key) {
        Jedis jedis = this.getJedis();
        boolean value = jedis.exists(key);
        this.closeJedis(jedis);
        return value;
    }

    public boolean exists(byte[] key) {
        Jedis jedis = this.getJedis();
        boolean value = jedis.exists(key);
        this.closeJedis(jedis);
        return value;
    }

    public List<String> lrange(String key, long start, long end) {
        Jedis jedis = this.getJedis();
        List<String> value = jedis.lrange(key, start, end);
        this.closeJedis(jedis);
        return value;
    }

    public long lpush(String key, String value) {
        Jedis jedis = this.getJedis();
        long rs = jedis.lpush(key, value);
        this.closeJedis(jedis);
        return rs;
    }

    public String rpop(String key) {
        Jedis jedis = this.getJedis();
        String value = jedis.rpop(key);
        this.closeJedis(jedis);
        return value;
    }

    public long expire(String key, int seconds) {
        Jedis jedis = this.getJedis();
        long rs = jedis.expire(key, seconds);
        this.closeJedis(jedis);
        return rs;
    }

    public long sadd(String key, String value) {
        Jedis jedis = this.getJedis();
        long rs = jedis.sadd(key, value);
        this.closeJedis(jedis);
        return rs;
    }

    public long sadd(String key, String[] values) {
        Jedis jedis = this.getJedis();
        long rs = jedis.sadd(key, values);
        this.closeJedis(jedis);
        return rs;
    }

    public long srem(String key, String... values) {
        Jedis jedis = this.getJedis();
        long rs = jedis.srem(key, values);
        this.closeJedis(jedis);
        return rs;
    }
    public Set<String> smembers(String key) {

        Jedis jedis = this.getJedis();
        Set<String> members = jedis.smembers(key);
        this.closeJedis(jedis);
        return members;
    }

    public boolean sismember(String key, String value) {
        Jedis jedis = this.getJedis();
        boolean rs = jedis.sismember(key, value);
        this.closeJedis(jedis);
        return rs;
    }

    public long scard(String key) {
        Jedis jedis = this.getJedis();
        long length = jedis.scard(key);
        this.closeJedis(jedis);
        return length;
    }

    public long pub(String channel, String message) {
        Jedis jedis = this.getJedis();
        long rs = jedis.publish(channel, message);
        this.closeJedis(jedis);
        return rs;
    }

    public long llen(String key) {
        Jedis jedis = this.getJedis();
        long length = jedis.llen(key);
        this.closeJedis(jedis);
        return length;
    }

    public long incr(String key) {
        Jedis jedis = this.getJedis();
        long rs = jedis.incr(key);
        this.closeJedis(jedis);
        return rs;
    }

    public long zadd(String key, double score, String member) {
        Jedis jedis = this.getJedis();
        long rs = jedis.zadd(key, score, member);
        this.closeJedis(jedis);
        return rs;
    }

    public Set<String> zrange(String key, int start, int stop) {
        Jedis jedis = this.getJedis();
        Set<String> rs = jedis.zrange(key, start, stop);
        this.closeJedis(jedis);
        return rs;
    }

    private JedisPool pool;

    public Jedis getJedis() {
        return pool.getResource();
    }

    public void closeJedis(Jedis jedis) {
        jedis.close();
    }

    public RedisClient(JedisPool pool) {
        this.pool = pool;
    }

}