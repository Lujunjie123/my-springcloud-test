package com.kuang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kuang.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping("/con/fallback/{id}")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//只负责sentinel控制台的异常违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
        exceptionsToIgnore = {IllegalArgumentException.class})
    public String get(@PathVariable("id") Long id){
        String s = restTemplate.getForObject(serverUrl + "/sql/" + id, String.class);
        if(id==4){
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        }else if(id>4||id<=0){
            throw new NullPointerException("NullPointerException 该ID没记录,空指针异常");
        }
        return s;
    }
    public String handlerFallback(@PathVariable("id") Long id, Throwable e){
        return "兜底异常"+e.getMessage()+"---业务异常--";
    }
    public String blockHandler(@PathVariable("id") Long id, BlockException e){
        return "兜底异常"+e.getMessage()+"---sentinel控制台异常违规--";
    }

    @Resource
    private FeignService feignService;

    @GetMapping("/con/sql/{id}")
    public CommonResult sql(@PathVariable("id") Long id){
        return feignService.sql(id);
    }
}

