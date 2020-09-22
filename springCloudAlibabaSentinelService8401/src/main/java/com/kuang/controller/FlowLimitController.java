package com.kuang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        log.info(Thread.currentThread().getName()+"----testA");
        return "----testA";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"----testB");
        return "----testB";
    }
    @GetMapping("/testD")
    public String testD(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info(Thread.currentThread().getName()+"----testD 测试RT");

        log.info(Thread.currentThread().getName()+"----testD 异常处理");
        int age = 10/0;
        return "----testD";
    }
    @GetMapping("/testE")
    public String testE(){
        log.info(Thread.currentThread().getName()+"----testE 异常数");
        int age = 10/0;
        return "----testE";
    }
    @GetMapping("/testHostKey")
    @SentinelResource(value = "testHostKey",blockHandler = "deal_testHostKey")
    public String testHostKey(@RequestParam(value = "p1",required = false)String p1,
                              @RequestParam(value = "p2",required = false)String p2){
//        int age = 10/0;           //运行时异常@SentinelResource不会处理，只会处理sentinel控制台配置的违规情况
        return "----testHostKey";
    }
    public String deal_testHostKey(String p1, String p2, BlockException e){
        return "----deal_testHostKey-- 热点key--";
    }
}
