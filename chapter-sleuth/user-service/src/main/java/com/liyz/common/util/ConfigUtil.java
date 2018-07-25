package com.liyz.common.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件工具类
 * @author lishuaifeng
 *
 */
@Component
public class ConfigUtil implements EnvironmentAware{
private static Environment environment;
	
	@Override
	public void setEnvironment(Environment environment) {
		ConfigUtil.environment = environment;
	}
	/**
	 * 根据key从application.properties配置文件中获取value
	 * 如果属性不存在则返回""
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return environment.getProperty(key,"");
	}
	/**
	 * 根据key从application.properties配置文件中获取value
	 * 如果属性不存在则返回给定值
	 * @param key
	 * @param defaultValue 默认返回值
	 * @return
	 */
	public static String getValue(String key ,String defaultValue){
		return environment.getProperty(key, defaultValue);
	}
}
