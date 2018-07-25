package com.liyz.common.util;

import com.alibaba.fastjson.JSONObject;
import com.liyz.common.util.exception.BzException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Package : com.yixin.settle.serviceImpl.rest
 * rest请求发送工具类
 * @author YixinCapital -- liuxing
 *		   2016年9月29日 下午8:52:53
 *
 */
public class RestUtil {
	private static final RestTemplate template;
	private static HttpHeaders headers ;
	
	static{
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(1000*60*10);// 设置超时时间10分钟
		requestFactory.setReadTimeout(1000*60*10);
		template = new RestTemplate(requestFactory);
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
	}

	private RestUtil(){
		 throw new IllegalAccessError("Utility class");
	}
	

	/**
	 * Rest发送post请求
	 * @param url
	 * @param parameter Object对象
	 * @return String post请求结果
	 * @author YixinCapital -- liuxing
	 *	       2016年9月29日 下午8:53:37
	 */
	public static String sendRequest(String url,Object parameter) throws BzException
	{
		try {
			if (null != parameter) {
				String resultDto = null;
				String jsonStr = JSONObject.toJSONString(parameter);
				HttpEntity<String> formEntity = new HttpEntity<>(
						jsonStr, headers);
				resultDto = template.postForObject(url, formEntity,String.class);
				return resultDto;
			}
		} catch (Exception e) {
			throw new BzException("调用地址:" + url + "异常!",e);
		}
		return null;
	}
	/**
	 * rest发送get请求
	 *
	 * @param url
	 * @return String get请求结果
	 * @throws BzException
	 * @author YixinCapital -- lizhongxin
	 *	       2017年9月15日 下午2:06:03
	 */
	public static String sendRequestForGet(String url) throws BzException{
		try {
			String resultDto = null;
			resultDto = template.getForObject(url,String.class);
			return resultDto;
		} catch (Exception e) {
			throw new BzException("调用地址：" + url + "异常！",e);
		}
	}
	
	/**
	 * Rest发送请求
	 * @param url
	 * @param parameter
	 * @return
	 * @author YixinCapital -- liuxing
	 *	       2016年9月29日 下午8:53:37
	 */
	public static String sendRequestWithoutTrans(String url, String parameter) throws BzException {
		try {
			if (null != parameter) {
				String resultDto = null;
				HttpEntity<String> formEntity = new HttpEntity<>(parameter, headers);
				resultDto = template.postForObject(url, formEntity,String.class);
				return resultDto;
			}
		} catch (Exception e) {
			throw new BzException("调用地址：" + url + "异常！",e);
		}

		return null;
	}
}
