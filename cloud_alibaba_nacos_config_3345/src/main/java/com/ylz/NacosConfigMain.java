package com.ylz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
public class NacosConfigMain {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain.class);
    }
}
