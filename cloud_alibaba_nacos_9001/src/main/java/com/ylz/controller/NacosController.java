package com.ylz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NacosController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/test")
    public String diaoyong(){
        return "nacos调用成功"+port;
    }
}
