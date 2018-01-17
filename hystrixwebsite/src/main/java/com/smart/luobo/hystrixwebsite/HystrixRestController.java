package com.smart.luobo.hystrixwebsite;

import com.smart.luobo.hystrixwebsite.config.SmsSendCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
@RequestMapping("/hystrix")
public class HystrixRestController {

    @RequestMapping("/timeout")
    public String timeOut(){
        return new SmsSendCommand().execute();
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() throws Exception {
        URL url = new URL("http://localhost:9001/sms/query/1");
        byte[] result = new byte[1024];
        url.openStream().read(result);
        return new String(result);
    }
}
