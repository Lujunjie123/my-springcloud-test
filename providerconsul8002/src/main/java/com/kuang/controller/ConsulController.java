package com.kuang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class ConsulController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/pro/consul")
    public String consul(){
        return "consul-"+serverPort+"-"+ UUID.randomUUID().toString();
    }
}
