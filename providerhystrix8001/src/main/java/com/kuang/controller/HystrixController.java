package com.kuang.controller;

import com.kuang.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @Value("${server.port}")
    private String serverport;

    @RequestMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        String result = hystrixService.ok(id);
        log.info("result=="+result);
        return result;
    }
    @RequestMapping("/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        String result = hystrixService.timeout(id);
        log.info("result=="+result);
        return result;
    }
    @RequestMapping("/hystrix/circuitBreaker/{id}")
    public String CircuitBreaker(@PathVariable("id") Integer id){
        String result = hystrixService.CircuitBreaker(id);
        log.info("result=="+result);
        return result;
    }
    @RequestMapping("/lb")
    public String lb(){
        return serverport;
    }
}





































