package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosClient3377.class,args);
    }
}
