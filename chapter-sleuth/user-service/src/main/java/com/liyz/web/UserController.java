package com.liyz.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author : 禹璋
 *@Description:
 *@Date: 2018/7/13
 *@Time：9:08
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Value("${foo}")
	String foo;
	
	@GetMapping("/hi")
	public String hi(){
		return "I'm liyz " + foo;
	}
}
