package com.kuang.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixServiceImpl implements HystrixService {

    @Override
    public String ok(Integer id) {
        return Thread.currentThread().getName()+"ok id:"+id;
    }

    //超过5s就用备选方案
    @HystrixCommand(fallbackMethod="timeoutHander",commandProperties={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @Override
    public String timeout(Integer id) {
//        int i = 10/0;      //异常也会走备选方案
        int timeNumber = 6;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+"timeout id:"+id+"haha";
    }
    public String timeoutHander(Integer id) {
        return Thread.currentThread().getName()+"timeout id:"+id+"8001系统繁忙";
    }

//    =======熔断================     参数在HystrixCommandProperties中
    @HystrixCommand(fallbackMethod = "CircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),       //是否开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")   //失败率达到多少熔断
    })
    public String CircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("===id不能为负数===");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"流水号:"+simpleUUID+" id:"+id;
    }

    public String CircuitBreaker_fallback(Integer id) {
        return "id不能为负数，请稍后再试，id:"+id;
    }


}





























