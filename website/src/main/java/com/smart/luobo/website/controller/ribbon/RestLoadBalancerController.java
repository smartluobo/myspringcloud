package com.smart.luobo.website.controller.ribbon;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/restload")
public class RestLoadBalancerController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/pro",method = RequestMethod.GET)
    public String properties(){
        String body = restTemplate.getForObject("http://service-by-properties/",String.class);
        return body;
    }

    @RequestMapping(value = "/anno",method = RequestMethod.GET)
    public String annotation(){
        String body = restTemplate.getForObject("http://service-by-annotation/",String.class);
        return body;
    }

    @RequestMapping(value = "/eureka",method = RequestMethod.GET)
    public String eureka(){
        String body = restTemplate.getForObject("http://sms-server-1/sms-server/sms",String.class);
        return body;
    }
}
