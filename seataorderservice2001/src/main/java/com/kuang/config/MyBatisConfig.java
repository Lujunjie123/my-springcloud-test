package com.kuang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kuang.dao")
public class MyBatisConfig {
}
