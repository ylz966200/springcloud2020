package com.ylz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void sendMsg(){
        this.redisTemplate.convertAndSend("phone","{'aaa':'ccc'}");
    }
}
