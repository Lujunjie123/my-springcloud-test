package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConsumerEurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerEurekaMain.class,args);
    }
}
