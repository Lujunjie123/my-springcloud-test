package com.kuang.service;

import org.springframework.stereotype.Component;

//服务端宕机降级处理
@Component
public class FallbackService implements FeignHystrixService {

    @Override
    public String ok(Integer id) {
        return "服务器已经宕机了,ok---id";
    }

    @Override
    public String timeout(Integer id) {
        return "服务器已经宕机了,timeout---id";
    }
}
