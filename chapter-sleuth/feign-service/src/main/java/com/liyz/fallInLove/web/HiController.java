package com.liyz.fallInLove.web;

import com.liyz.fallInLove.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author : 禹璋
 *@Description:对外暴露一个”/hi”的API接口，通过上面定义的Feign客户端SchedualServiceHi 来消费服务
 *@Date: 2018/7/13
 *@Time：9:34
 */
@RestController
@RequestMapping("/user")
public class HiController {
	
	@Autowired
	SchedualServiceHi schedualServiceHi;
	
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	public String sayHi(@RequestParam String name){
		return schedualServiceHi.sayHiFromClientOne(name);
	}
}
