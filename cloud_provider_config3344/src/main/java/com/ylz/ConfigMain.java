package com.ylz;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@EnableRabbit
@SpringBootApplication
public class ConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain.class);
    }
}
