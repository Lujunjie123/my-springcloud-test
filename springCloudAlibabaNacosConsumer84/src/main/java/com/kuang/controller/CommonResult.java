package com.kuang.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonResult {
    private int code;
    private String message;
    private String s2;
    public CommonResult() {
    }

    public CommonResult(int code) {
        this.code = code;
    }

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(int code, String message, String s2) {
        this.code = code;
        this.message = message;
        this.s2 = s2;
    }
}
