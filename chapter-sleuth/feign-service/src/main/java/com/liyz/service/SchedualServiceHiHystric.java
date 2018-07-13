package com.liyz.service;

import org.springframework.stereotype.Component;
/**
 *@Author : 禹璋
 *@Description:
 *@Date: 2018/7/13
 *@Time：9:31
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{
	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry"+name;
	}
}
