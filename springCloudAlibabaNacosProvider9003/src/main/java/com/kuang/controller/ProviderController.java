package com.kuang.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ProviderController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long,String> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,"aaa");
        hashMap.put(2L,"bbb");
        hashMap.put(3L,"ccc");
    }

    @GetMapping("/sql/{id}")
    public CommonResult sql(@PathVariable("id") Long id){

        return new CommonResult(200,"from mysql serverPort:"+serverPort,hashMap.get(id));
    }

}

























































