package com.ylz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class testController {
    @Value("${config.version}")
    private String configVersion;


    @GetMapping("/getConfig")
    public String getConfigVersion(){
        return this.configVersion;
    }
}
