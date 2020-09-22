package com.kuang.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "providereureka",fallback = FallbackService.class)
public interface FeignHystrixService {

    @GetMapping("/hystrix/ok/{id}")
    public String  ok(@PathVariable("id") Integer id);


    @GetMapping("/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id);

}
