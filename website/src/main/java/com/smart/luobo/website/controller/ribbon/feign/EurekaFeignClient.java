package com.smart.luobo.website.controller.ribbon.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "sms-server-1")
public interface EurekaFeignClient {
    @RequestMapping(value = "/sms-server/sms",method = RequestMethod.GET)
    String index();

    @RequestMapping(value = "/hystrix/timeout",method = RequestMethod.GET)
    String timeOut();

    @RequestMapping(value = "/hystrix/exception",method = RequestMethod.GET)
    String exception();
}
