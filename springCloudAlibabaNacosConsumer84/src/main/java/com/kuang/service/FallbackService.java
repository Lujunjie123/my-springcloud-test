package com.kuang.service;

import com.kuang.controller.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class FallbackService implements FeignService{
    @Override
    public CommonResult sql(Long id) {
        return new CommonResult(444,"服务降级返回，----FallbackService");
    }
}
