package com.ylz.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ylz.base.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao extends BaseMapper<Payment> {
}
