package com.kuang.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Component
@FeignClient("providerfeign8003")
public interface FeignConfig {

    @RequestMapping("/pro/feign")
    public String info();

    @RequestMapping("/pro/feign/timeout")
    public String timeout() throws InterruptedException;
}
