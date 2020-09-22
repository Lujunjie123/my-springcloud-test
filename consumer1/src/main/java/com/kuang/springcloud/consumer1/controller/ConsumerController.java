package com.kuang.springcloud.consumer1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsumerController {

    public static final String INVOKE_URL="http://provider1";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/con/get")
    public String getmsg(){
       return restTemplate.getForObject(INVOKE_URL+"/pro/msg",String.class);
    }
}
