package com.kuang.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonResult {
    private int code;
    private String message;

    public CommonResult(int code,String message){
        this.code=code;
        this.message=message;
    }
}
