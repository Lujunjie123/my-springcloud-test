package com.kuang.controller;

import com.kuang.config.FeignConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignConfig feignConfig;

    @RequestMapping("/con/feign")
    public String get(){
       return feignConfig.info();
    }
    @RequestMapping("/con/feign/timeout")
    public String timeout() throws InterruptedException {
       return feignConfig.timeout();
    }

}
