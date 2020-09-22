package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class configcenter3344Main {
    public static void main(String[] args) {
        SpringApplication.run(configcenter3344Main.class,args);
    }
}
