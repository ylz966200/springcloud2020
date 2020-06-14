package com.ylz.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ylz.base.Payment;
import com.ylz.common.ReqBean;
import com.ylz.service.JwtService;
import com.ylz.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@EnableEurekaClient
@RefreshScope
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private JwtService jwtService;
    @Value("${springconfig.test}")
    private String getConfig;

    @RequestMapping("/configTest")
    public String getConfig(){
         return this.getConfig;
    }

    @GetMapping("/payment")
    public List<Payment> getAll(){
         return this.paymentService.searchList();
    }

    @GetMapping("/sleep/{id}")
    public Payment sleep(@PathVariable Long id) throws InterruptedException {
        return this.paymentService.searchOne(id);
    }

    @GetMapping("/chaoshi")
    public String HystrixTest() throws InterruptedException {
        System.out.println("发生调用");
        return this.paymentService.chaoshi();
    }

    @GetMapping("/break/{id}")
    public String HystrixBreakTest(@PathVariable("id") Long id){
        return   this.paymentService.hystrixBreakTest(id);
    }

    @PostMapping("/testRedis")
    public String testRedis(@RequestBody ReqBean reqBean){
          this.paymentService.testSetRedis(reqBean.getKey(),reqBean.getValue());
          return "成功";
    }

    @GetMapping("/getToken")
    public String getToken(){
        return  this.jwtService.createToken();
    }

    @GetMapping("/verifyToken")
    public void verifyToken(HttpServletRequest request){
        String token= request.getHeader("token");
         this.jwtService.verifyToken(token);
    }


}
