package com.kuang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsulController {

    @Autowired
    RestTemplate restTemplate;

    private static final String path = "http://providerconsul8002";

    @GetMapping("/con/consul")
    public String get(){
        return restTemplate.getForObject(path+"/pro/consul",String.class);
    }

}
