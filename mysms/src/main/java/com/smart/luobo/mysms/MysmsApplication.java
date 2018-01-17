package com.smart.luobo.mysms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MysmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysmsApplication.class, args);
	}
}
