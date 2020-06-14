package com.ylz.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ylz.service.PaymentService;
import com.ylz.base.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@DefaultProperties(defaultFallback = "failBack")
public class PaymentController {
   @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public List<Payment> getList(){
        return this .paymentService.getAll();
    }

    @GetMapping("/sleep/{id}")
    public Payment sleep(@PathVariable Long id ){
        return this .paymentService.sleep(id);
    }

    @GetMapping("/hystrixTest")
//    @HystrixCommand
    public String hystrixTest(){
        return this.paymentService.HystrixTest();
    }

    @GetMapping("/hystrixBreakTest/{id}")
    public String hystrixBreakTest(@PathVariable("id") Long id){
        return this.paymentService.HystrixBreakTest(id);
    }

    public String failBack(){
        return "客户端调用超时";
    }
}
