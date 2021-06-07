package com.chen.springcloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.chen.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenhongchang
 * @date 2021/6/6 0006 - 上午 10:46
 */
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService service;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return service.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){

        // openfeign-ribbon 客户端默认等待 1 秒，但业务逻辑要执行三秒
        return service.paymentFeignTimeout();
    }
}
