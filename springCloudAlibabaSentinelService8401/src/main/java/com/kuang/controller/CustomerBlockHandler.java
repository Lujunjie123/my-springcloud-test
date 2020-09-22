package com.kuang.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static CommonResult hanlerException1(BlockException exception){
        return new CommonResult(444,"按客户自定义,global-----1");
    }
    public static CommonResult hanlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义,global-----2");
    }

}
