package com.kuang.springcloud.provider1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/pro/msg")
    public String msg(){
        return "aaa--"+serverPort+"--"+UUID.randomUUID().toString();
    }
}
