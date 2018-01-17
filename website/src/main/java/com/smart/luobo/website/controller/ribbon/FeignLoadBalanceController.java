package com.smart.luobo.website.controller.ribbon;

import com.smart.luobo.website.controller.ribbon.feign.AnnotationFeignClient;
import com.smart.luobo.website.controller.ribbon.feign.EurekaFeignClient;
import com.smart.luobo.website.controller.ribbon.feign.PropertiesFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feignribbon")
public class FeignLoadBalanceController {

    @Resource
    private PropertiesFeignClient propertiesFeignClient;

    @Resource
    private AnnotationFeignClient annotationFeignClient;

    @Resource
    private EurekaFeignClient eurekaFeignClient;

    @RequestMapping(value = "/pro",method = RequestMethod.GET)
    public String properties(){
        String body = propertiesFeignClient.index();
        return body;
    }

    @RequestMapping(value = "/anno",method = RequestMethod.GET)
    public String annotation(){
        String body = annotationFeignClient.index();
        return body;
    }

    @RequestMapping(value = "/eureka/sms",method = RequestMethod.GET)
    public String eureka(){
        String body = eurekaFeignClient.index();
        return body;
    }

    @RequestMapping(value = "/eureka/timeout",method = RequestMethod.GET)
    public String timeOut(){
        String body = eurekaFeignClient.timeOut();
        return body;
    }

    @RequestMapping(value = "/eureka/exception",method = RequestMethod.GET)
    public String exception(){
        String body = eurekaFeignClient.exception();
        return body;
    }
}
