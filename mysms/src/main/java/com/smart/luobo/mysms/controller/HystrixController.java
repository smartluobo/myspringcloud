package com.smart.luobo.mysms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @RequestMapping(value = "/timeout",method =  RequestMethod.GET)
    public String timeOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping(value = "/exception",method = RequestMethod.GET)
    public String exception(HttpServletResponse response) throws IOException {
        if(new Random().nextInt(10) % 2 == 0){
            response.setStatus(503);
            response.getWriter().write("error");
            response.flushBuffer();
        }
        return "ok";
    }
}
