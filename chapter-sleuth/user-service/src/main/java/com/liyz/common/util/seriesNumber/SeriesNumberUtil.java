package com.liyz.common.util.seriesNumber;


import com.liyz.common.util.RedisClientUtil;
import com.liyz.common.util.exception.BzException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SeriesNumberUtil {
	private static Logger logger = LoggerFactory.getLogger(SeriesNumberUtil.class);
	private static String PREFIX = "vehiclemart:";
	private static String DATE_PATTERN = "yyyyMMdd";
	private static String NUM_PATTERN_MIN = "%04d";
	private static String NUM_PATTERN_MAX = "%015d";
	private static int DEFAULT_SERIES_LEN = 4;
	
	private static String getDateStr(){
		return DateUtils.formatDate(new Date(), DATE_PATTERN);
	}
	
	private static RedisClientUtil redisClientUtil;
	@Autowired
	public void setRedisClientUtil(RedisClientUtil redis){
		redisClientUtil = redis;
	}
	/**
	 * 生成4位序列号
	 * @param type
	 * @return
	 */
	public static String getSeriesNo(String type){
		return getSeriesNo(type,DEFAULT_SERIES_LEN);
	}
	/**
	 * 按传入长度参数生成对应位数的序列号
	 * @param type
	 * @param seriesLen  传入数值小于4位按4位处理  大于15按15位处理
	 * @return
	 */
	public static String getSeriesNo(String type,int seriesLen) {
		try {
			if(StringUtils.isBlank(type)){
				throw new Exception("序列号类型不能为空！");
			}
			String dateStr = getDateStr();
			String key = PREFIX+type+":"+dateStr;
			String seriesPreFix = type.toUpperCase()+dateStr;
			long num = redisClientUtil.incr(key);
			String num_pattern = "%04d";
			if(seriesLen<=4){
				num_pattern = NUM_PATTERN_MIN;
			}else if(seriesLen<15){
				num_pattern = "%0"+seriesLen+"d";
			}else{
				num_pattern = NUM_PATTERN_MAX;
			}
			return seriesPreFix+=String.format(num_pattern, num);
		} catch (Exception e) {
			logger.warn("获取序列号出错，信息为：{}",e);
			throw new BzException("生成序列号出错，请稍后再试！");
		}
	}
	/**
	 * 默认生成数字部分为4位的序列号  序列号例如  ZR+yyyyMMdd+0001
	 * @param type
	 * @return
	 */
	/*public static String getSeriesNo(NumPreFixEnum type) {
		return getSeriesNo(type,DEFAULT_SERIES_LEN);
	}*/
	/**
	 * 序列号生成服务,依赖redis生成自增值,存在的问题是redis宕机恰好在redis两次数据备份之间有新的序列号生成，
	 * 在redis重启服务恢复数据之后会出现重复的序列号---
	 * 解决方式：将序列号字段设置为mysql表的唯一性索引。使重复的序列号不能正常插入。
	 * 程序日志中有唯一索引约束插入数据的报错时候就需要重置redis对应的key的自增值
	 * @param  seriesLen  序列号数字部分长度 例如传 5就是  00001   传入数值小于4位按4位处理  大于15按15位处理
	 */
	/*public static String getSeriesNo(NumPreFixEnum type,int seriesLen) {
		try {
			if(type==null){
				throw new BzException("序列号类型不能为空！");
			}
			String dateStr = getDateStr();
			String key = PREFIX+type.getValue()+":"+dateStr;
			String seriesPreFix = type.getValue()+dateStr;
			long num = redisClientUtil.incr(key);
			String num_pattern = "%04d";
			if(seriesLen<=4){
				num_pattern = NUM_PATTERN_MIN;
			}else if(seriesLen<15){
				num_pattern = "%0"+seriesLen+"d";
			}else{
				num_pattern = NUM_PATTERN_MAX;
			}
			return seriesPreFix+=String.format(num_pattern, num);
		} catch (Exception e) {
			logger.warn("获取序列号出错，信息为：{}",e);
			throw new BzException("生成序列号出错，请稍后再试！");
		}
	}*/
}
