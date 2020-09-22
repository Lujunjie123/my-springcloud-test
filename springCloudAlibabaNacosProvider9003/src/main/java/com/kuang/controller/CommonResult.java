package com.kuang.controller;

import lombok.Data;

@Data
public class CommonResult {
    private int code;
    private String message;
    private String s2;

    public CommonResult(int code, String message){
        this.code=code;
        this.message=message;
    }

    public CommonResult(int code, String message,String s2){
        this(code,message);
        this.s2 = s2;
    }
}
