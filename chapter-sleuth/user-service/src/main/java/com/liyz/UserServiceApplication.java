package com.liyz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@Author : 禹璋
 *@Description:应用服务，对外暴露API接口，同时它也作为链路追踪客户端，负责产生数据。
 *@Date: 2018/7/13
 *@Time：9:52
 */
@SpringBootApplication
@EnableEurekaClient
@RefreshScope
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
}
