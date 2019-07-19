package com.linjingc.logindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class LoginDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginDemoApplication.class, args);
    }

}
