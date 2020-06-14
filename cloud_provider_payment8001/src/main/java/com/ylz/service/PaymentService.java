package com.ylz.service;

import cn.hutool.core.thread.ThreadUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ylz.base.Payment;
import com.ylz.mapper.PaymentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private RedisTemplate redisTemplate;

    public List<Payment> searchList(){
       return  this.paymentDao.selectList(null);
    }

    public Payment searchOne(Long id){
        return  this.paymentDao.selectById(id);
    }

    /**
     * Hystrix测试
     * @return
     * @throws InterruptedException
     */
    public String chaoshi() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return Thread.currentThread().getName()+"线程超时";
    }

    @HystrixCommand(fallbackMethod="shibai",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启熔断
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//窗口时间，例如在1s内调用多少次失败
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//失败率
    })
    public String hystrixBreakTest(Long id){
        if(id<0){
            throw  new RuntimeException("id不能小于0");
        }
        return "成功，调用的id是"+id;
    }

    public void testSetRedis(String key,String value){
        log.info("向redis发送消息,key:"+key+";value:"+value);
        this.redisTemplate.convertAndSend(key,value);
    }

    public String shibai( Long id){
        return "失败，调用的id是"+id;
    }
}
