package com.liyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

/**
 *@Author : 禹璋
 *@Description:链路追踪服务中心，负责存储链路数据
 *@Date: 2018/7/13
 *@Time：9:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinStreamServer
@Configuration
@EnableAsync
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
	
	@Bean
	public MySQLStorage mySQLStorage(DataSource datasource) {
		return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
	}
}
