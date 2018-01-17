package com.smart.luobo.mysms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class FeignController {

    @RequestMapping(value = "/query/{id}",method = RequestMethod.GET)
    public String querySms(@PathVariable("id") String id){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "FeignController querySms success"+id;
    }

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public String sendSms(){
        return "FeignController sendSms success";
    }
}
