package com.kuang.controller;

import com.kuang.service.FeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "globalHander")
public class HystrixController {

    @Autowired
    FeignHystrixService feignHystrixService;

    @RequestMapping("/con/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        return feignHystrixService.ok(id);
    }

//    @HystrixCommand(fallbackMethod ="timeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @RequestMapping("/con/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {
//        int age = 10/0;
        return feignHystrixService.timeout(id);
    }
    public String timeoutHandler(@PathVariable("id") Integer id) {
        return "我是消费者80,服务系统繁忙,请等待10s后再试或运行出错检查自己";
    }

    public String globalHander() {
        return "Global异常处理信息，请稍后重试";
    }
}

























