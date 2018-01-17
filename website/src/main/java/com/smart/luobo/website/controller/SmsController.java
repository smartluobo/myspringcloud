package com.smart.luobo.website.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sms")
public class SmsController {

    public static int index = 0;

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/callSms")
    public String callSms(){
        List<ServiceInstance> smsServices = discoveryClient.getInstances("sms-server-1");
        ServiceInstance smsService = smsServices.get(index++%smsServices.size());
        String host = smsService.getHost();
        int port = smsService.getPort();

        String url = "http://" + host + ":" + port + "/sms-server/sms";
        String result = new RestTemplate().getForObject(url, String.class);
        return "smsService "+host+":"+port+" return message:" + result;
    }
}
