package com.kuang.service;

import com.kuang.controller.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider",fallback = FallbackService.class)
public interface FeignService {

    @GetMapping("/sql/{id}")
    public CommonResult sql(@PathVariable("id") Long id);
}
