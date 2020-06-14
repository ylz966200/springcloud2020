package com.ylz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain {

    public static void main(String[] args) {
            SpringApplication.run(PaymentConsulMain.class,args);

    }
}
