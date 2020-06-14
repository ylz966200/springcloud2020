package com.ylz.service;

import com.ylz.base.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentFailBackFactory implements PaymentService {
    @Override
    public List<Payment> getAll() {
        return null;
    }

    @Override
    public Payment sleep(Long id) {
        return null;
    }

    @Override
    public String HystrixTest() {
        return "工厂类的调用失败";
    }

    @Override
    public String HystrixBreakTest(Long id) {
        return "熔断测试调用失败";
    }
}
