package com.smart.luobo.website.controller;

import com.smart.luobo.website.service.FeignSmsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feign")
public class FeignSmsController {

    @Resource
    private FeignSmsService feignSmsService;

    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    public String querySms(@PathVariable("id") String id){
        String s = feignSmsService.querySms(id);
        return s;
    }

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String sendSms(){
        String result = feignSmsService.sendSms();
        return result;
    }
}
