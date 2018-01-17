package com.smart.luobo.website.controller.ribbon;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/load")
public class LoadBalanceController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/pro",method = RequestMethod.GET)
    public String properties(){
        ServiceInstance choose = loadBalancerClient.choose("service-by-properties");
        return choose.getUri().toString();
    }

    @RequestMapping(value = "/anno",method = RequestMethod.GET)
    public String annotation(){
        ServiceInstance choose = loadBalancerClient.choose("service-by-annotation");
        return choose.getUri().toString();
    }

    @RequestMapping(value = "/eureka",method = RequestMethod.GET)
    public String eureka(){
        ServiceInstance choose = loadBalancerClient.choose("sms-server-1");
        return choose.getHost() + ":" + choose.getPort();
    }
}
