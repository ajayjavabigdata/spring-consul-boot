package com.spring.consul.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@EnableConfigurationProperties
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationConsul {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationConsul.class, args);
    }


}
