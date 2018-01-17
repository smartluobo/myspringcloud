package com.smart.luobo.website.controller.ribbon.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service-by-annotation")
public interface AnnotationFeignClient {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    String index();
}
