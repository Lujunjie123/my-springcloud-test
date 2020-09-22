package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosConsumer83Main {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer83Main.class,args);
    }
}
