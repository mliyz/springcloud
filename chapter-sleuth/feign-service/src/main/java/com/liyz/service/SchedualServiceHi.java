package com.liyz.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@Author : 禹璋
 *@Description:当 user-service 工程不可用的时候，service-ribbon调用 user-service的API接口时，会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞。
 * 通过@ FeignClient（“服务名”），来指定调用哪个服务
 * @Date: 2018/7/13
 *@Time：9:28
 */
@FeignClient(value = "user-service",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
	@RequestMapping(value = "/user/hi",method = RequestMethod.GET)
	String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
