package com.kuang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsumerController {

    public static final String PATH_URL="http://providereureka";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("con/zipkin")
    public String zipkin(){
        return restTemplate.getForObject(PATH_URL+"/zipkin",String.class);
    }
    @GetMapping("con//hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PATH_URL+"/hystrix/ok/{id}",String.class,id);
    }
    @GetMapping("con//hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PATH_URL+"/hystrix/timeout/{id}",String.class,id);
    }
    @GetMapping("con//hystrix/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PATH_URL+"/hystrix/circuitBreaker/{id}",String.class,id);
    }
}
