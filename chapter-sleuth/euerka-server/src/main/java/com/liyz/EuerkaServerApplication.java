package com.liyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 *@Author : 禹璋
 *@Description:服务注册中心
 *@Date: 2018/7/13
 *@Time：9:50
 */
@SpringBootApplication
@EnableEurekaServer
public class EuerkaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuerkaServerApplication.class, args);
	}
}
