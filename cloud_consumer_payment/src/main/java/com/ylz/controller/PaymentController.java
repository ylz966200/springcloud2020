package com.ylz.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ylz.base.Payment;
import com.ylz.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PaymentService paymentService;

    private static final String url="http://cloud-payment-service";

    @GetMapping("/payment")
    public List<Payment> getList(){
        ResponseEntity<List> resBody=  this.restTemplate.getForEntity(url+"/payment",List.class);
        return resBody.getBody();
    }

    @GetMapping("/hystrixTest")
    @HystrixCommand(fallbackMethod="failBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
    })
    public String hystrixTest(){
        ResponseEntity<String> resBody=  this.restTemplate.getForEntity(url+"/chaoshi",String.class);
        return resBody.getBody();
    }

//    @RequestMapping("/sendMsg")
//    public void sendMsg(){
//        this.paymentService.sendMsg();
//    }

    public String failBack(){
        return "服务方调用超时，请稍后再试";
    }
}
