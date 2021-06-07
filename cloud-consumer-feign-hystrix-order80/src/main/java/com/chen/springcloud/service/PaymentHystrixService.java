package com.chen.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenhongchang
 * @date 2021/6/6 0006 - 下午 5:53
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",
             fallback = PaymentFallbackService.class)//指定PaymentFallbackService类
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/get/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/get_timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
