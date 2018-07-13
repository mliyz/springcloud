package com.liyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
/**
 *@Author : 禹璋
 *@Description:断路器聚合监控(Hystrix Turbine)
 *@Date: 2018/7/13
 *@Time：17:45
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class ServiceTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTurbineApplication.class, args);
	}
}
