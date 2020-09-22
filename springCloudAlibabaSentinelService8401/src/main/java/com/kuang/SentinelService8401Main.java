package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelService8401Main {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401Main.class,args);
    }
}
