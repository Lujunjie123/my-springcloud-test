package com.kuang.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {

    @Bean
    Logger.Level log(){
        return Logger.Level.FULL;
    }
}
