package com.smart.luobo.website.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sms-server-1")
public interface FeignSmsService {

    @RequestMapping(value = "/sms/query/{id}",method = RequestMethod.GET)
    String querySms(@PathVariable("id") String id);

    @RequestMapping(value = "/sms/send",method = RequestMethod.GET)
    String sendSms();

}
