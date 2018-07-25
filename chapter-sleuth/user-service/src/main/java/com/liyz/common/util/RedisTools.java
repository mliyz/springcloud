package com.liyz.common.util;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis操作工具类
 */
public class RedisTools
{

    private JedisCluster jedisCluster;

    public RedisTools(JedisCluster jedisCluster) {
        super();
        this.jedisCluster = jedisCluster;
    }

    // ----------------------- common handle -------------------------

    /**
     * 根据KEY删除记录
     *
     * @param key
     * @return
     */
    public boolean del(String key) {
        jedisCluster.del(key);
        return true;
    }

    /**
     * 判断Key是否存在
     *
     * @param key
     * @return
     */
    public boolean exist(String key) {
        return jedisCluster.exists(key);
    }

    /**
     * 判断key+domain是否存在
     *
     * @param domain 域名
     * @param key    键值
     * @return
     */

    public boolean existsHSet(String domain, String key) {
        return jedisCluster.hexists(key, domain);
    }

    /**
     * 全局扫描hset
     *
     * @param match field匹配模式
     * @return
     */
    public List<Map.Entry<String, String>> scanHSet(String key, String match) {
        int cursor = 0;
        ScanParams scanParams = new ScanParams();
        scanParams.match(match);
        ScanResult<Map.Entry<String, String>> scanResult;
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
        do {
            scanResult = jedisCluster.hscan(key, String.valueOf(cursor));// .hscan(,
            // scanParams);
            list.addAll(scanResult.getResult());
            cursor = Integer.parseInt(scanResult.getStringCursor());
        } while (cursor > 0);
        return list;
    }

    /**
     * 返回 domain 指定的哈希集中所有字段的value值
     *
     * @param domain
     * @return
     */
    public List<String> hvals(String domain) {
        return jedisCluster.hvals(domain);
    }

    /**
     * 返回 domain 指定的哈希集中所有字段的key值
     *
     * @param domain
     * @return
     */
    public Set<String> hkeys(String domain) {
        return jedisCluster.hkeys(domain);
    }

    /**
     * 返回 domain 指定的哈希key值总数
     *
     * @param domain
     * @return
     */
    public long lenHset(String domain) {
        return jedisCluster.hlen(domain);
    }

    /**
     * 添加一个Key对应的Value,并设置有效期
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

    /**
     * 添加一个Key对应的Value
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        jedisCluster.set(key, value);
        return true;
    }

    /**
     * 追加一个Key对应的Value
     *
     * @param key
     * @param value
     * @return
     */
    public boolean append(String key, String value) {
        jedisCluster.append(key, value);
        return true;
    }

    /**
     * 获得Key对应的Value
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public String get(String key, String defaultValue) {
        String value = jedisCluster.get(key);
        if (null != value && !"".equals(value)) {
            return value;
        } else {
            return defaultValue;
        }
    }

    /**
     * 重命名key
     *
     * @param key
     * @param newKey
     * @return
     */
    public boolean rename(String key, String newKey) {
        jedisCluster.rename(key, newKey);
        return true;
    }

    /**
     * 数值+1
     *
     * @param key
     * @return
     */
    public long incr(String key) {
        return jedisCluster.incr(key);
    }

    /**
     * 数值-1
     *
     * @param key
     * @return
     */
    public long decr(String key) {
        return jedisCluster.decr(key);
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     */
    public void expire(String key, int seconds) {
        jedisCluster.expire(key, seconds);
    }

    // ----------------------- hSet handle -------------------------

    /**
     * 设置HashSet对象
     *
     * @param domain 域名
     * @param key    键值
     * @param value  Json String or String value
     * @return
     */

    public boolean setHSet(String key, String domain, String value) {
        jedisCluster.hset(key, domain, value);
        return true;
    }

    /**
     * 获得HashSet对象
     *
     * @param domain 域名
     * @param key    键值
     * @return Json String or String value
     */
    public String getHSet(String domain, String key) {
        return jedisCluster.hget(key, domain);
    }

    /**
     * 获取存储在键的散列的所有字段和值
     *
     * @param key 键值
     * @return
     */
    public Map<String, String> getHGetAll(String key) {
        return jedisCluster.hgetAll(key);
    }

    /**
     * 删除HashSet对象
     *
     * @param domain 域名
     * @param key    键值
     * @return 删除的记录数
     */

    public long delHSet(String domain, String key) {
        return jedisCluster.hdel(key, domain);
    }

    /**
     * 删除HashSet对象的指定domains
     *
     * @param domain 域名
     * @param key    键值
     * @return 删除的记录数
     */

    public long delHSet(String key, String... domain) {
        return jedisCluster.hdel(key, domain);
    }

    // ----------------------- sortedSet handle -------------------------

    /**
     * 设置排序集合
     *
     * @param key
     * @param score
     * @param value
     * @return
     */
    public boolean setSortedSet(String key, long score, String value) {
        jedisCluster.zadd(key, score, value);
        return true;
    }

    /**
     * 获得排序集合
     *
     * @param key
     * @param startScore
     * @param endScore
     * @param orderByDesc
     * @return
     */
    public Set<String> getSoredSet(String key, long startScore, long endScore, boolean orderByDesc) {
        if (orderByDesc) {
            return jedisCluster.zrevrangeByScore(key, endScore, startScore);
        } else {
            return jedisCluster.zrangeByScore(key, startScore, endScore);
        }
    }

    /**
     * 获得排序集合
     *
     * @param key
     * @param startScore
     * @param endScore
     * @param count
     * @param offset
     * @param orderByDesc
     * @return
     */
    public Set<String> getSoredSet(String key, long startScore, long endScore, int offset, int count,
            boolean orderByDesc) {
        if (orderByDesc) {
            return jedisCluster.zrevrangeByScore(key, endScore, startScore, offset, count);
        } else {
            return jedisCluster.zrangeByScore(key, startScore, endScore, offset, count);
        }
    }

    /**
     * 计算排序长度
     *
     * @param key
     * @param startScore
     * @param endScore
     * @return
     */
    public long countSoredSet(String key, long startScore, long endScore) {
        Long count = jedisCluster.zcount(key, startScore, endScore);
        return count == null ? 0L : count;
    }

    /**
     * 计算排序长度
     *
     * @param key
     * @return
     */
    public long countSoredSet(String key) {
        Long count = jedisCluster.zcard(key);
        return count == null ? 0L : count;
    }

    /**
     * 删除排序集合
     *
     * @param key
     * @param value
     * @return
     */
    public boolean delSortedSet(String key, String value) {
        long count = jedisCluster.zrem(key, value);
        return count > 0;
    }

    /**
     * 删除排序集合
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public boolean delRankSortedSet(String key, long start, long end) {
        long count = jedisCluster.zremrangeByRank(key, start, end);
        return count > 0;
    }

    /**
     * 删除排序部分集合
     *
     * @param key
     * @return
     */
    public boolean delSortedSet(String key, long minScore, long maxScore) {
        long count = jedisCluster.zremrangeByScore(key, minScore, maxScore);
        return count > 0;
    }

    /**
     * 根据分数排序获得前N个
     *
     * @param key
     * @param topN
     * @return
     */
    public Set<Tuple> zrevrangeWithScores(String key, int topN) {
        return jedisCluster.zrevrangeWithScores(key, 0, topN);
    }

    /**
     * 根据分数排序从指定位置获得数据
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        return jedisCluster.zrevrangeWithScores(key, start, end);
    }

    // ----------------------- List handle -------------------------

    /**
     * 列表lpush操作
     * 命令将一个或多个值插入到列表头部
     *
     * @param key
     * @param value
     */
    public void lpush(String key, String... value) {
        jedisCluster.lpush(key, value);
    }

    /**
     * 列表rpush操作
     * 将一个或多个值插入到列表的尾部(最右边)
     *
     * @param key
     * @param value
     */
    public void rpush(String key, String... value) {
        jedisCluster.rpush(key, value);
    }

    /**
     * 列表长度
     *
     * @param key
     */
    public long llen(String key) {
        return jedisCluster.llen(key);
    }

    /**
     * 根据start和stop获取列表
     *
     * @param key
     * @param start
     * @param stop
     * @return
     */
    public List<String> lrange(String key, int start, int stop) {
        return jedisCluster.lrange(key, start, stop);
    }

    /**
     * 列表删除
     *
     * @param key
     * @param count count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。 count < 0 :
     *              从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。 count = 0 : 移除表中所有与
     *              value 相等的值。
     * @param value
     * @return
     */
    public long lrem(String key, int count, String value) {
        return jedisCluster.lrem(key, count, value);
    }

    /**
     * 列表清理
     *
     * @param key
     * @param start
     * @param end
     */
    public void ltrim(String key, int start, int end) {
        jedisCluster.ltrim(key, start, end);
    }

    /**
     * 将一个或多个成员元素加入到集合中，已经存在于集合的成员元素将被忽略
     *
     * @param key
     * @param member
     * @return
     */
    public Long sadd(String key, String... member) {
        return jedisCluster.sadd(key, member);
    }

    /**
     * 删除成员
     *
     * @param key
     * @param member
     * @return
     */
    public Long srem(String key, String... member) {
        return jedisCluster.srem(key, member);
    }

    /**
     * 获取set所有成员
     *
     * @param key
     * @return
     */
    public Set<String> smembers(String key) {
        return jedisCluster.smembers(key);
    }

    /**
     * 判断member元素是否是集合key的成员
     *
     * @param key
     * @param member
     * @return
     */
    public boolean sismember(String key, String member) {
        return jedisCluster.sismember(key, member);
    }

    // ----------------------- mSet handle -------------------------
    public String setMSet(String key, Map<String, String> hash) {
        return jedisCluster.hmset(key, hash);
    }

}
