package com.ylz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosController {
@Autowired
public RestTemplate restTemplate;


private static final String serverUrl="http://springNacosServer";

    @GetMapping("/test")
    public String diaoyong(){
      return   this.restTemplate.getForObject(serverUrl+"/test",String.class);
    }
}
