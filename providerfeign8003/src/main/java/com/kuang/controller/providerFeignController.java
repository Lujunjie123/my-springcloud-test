package com.kuang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class providerFeignController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/pro/feign")
    public String info(){
        return ""+serverPort+ UUID.randomUUID().toString();
    }

    @RequestMapping("/pro/feign/timeout")
    public String timeout() throws InterruptedException {
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ""+serverPort+ UUID.randomUUID().toString();
    }
}
