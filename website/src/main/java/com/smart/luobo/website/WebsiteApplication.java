package com.smart.luobo.website;

import com.smart.luobo.website.config.ServiceByAnnotationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

import javax.naming.Name;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClients(value={@RibbonClient(name = "service-by-annotation",configuration = ServiceByAnnotationConfiguration.class)})
public class WebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteApplication.class, args);
	}
}
