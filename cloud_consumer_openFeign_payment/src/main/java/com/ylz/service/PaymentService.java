package com.ylz.service;

import com.ylz.base.Payment;
import com.ylz.service.PaymentFailBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "cloud-payment-service",fallback = PaymentFailBackFactory.class)
public interface PaymentService {

    @GetMapping("/payment")
    List<Payment> getAll();

    @GetMapping("/sleep/{id}")
    Payment sleep(@PathVariable(value = "id") Long id);

    @GetMapping("/chaoshi")
    String HystrixTest();

    @GetMapping("/break/{id}")
    public String HystrixBreakTest(@PathVariable("id") Long id);

    }
