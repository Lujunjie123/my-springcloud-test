package com.kuang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/{id}")
    public String get(@PathVariable("id") Integer id){
        return "nacos registry,serverport:"+serverPort+"id:"+id;
    }
}
