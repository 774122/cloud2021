package com.chen.springcloud.service;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.chen.springcloud.service.Impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenhongchang
 * @date 2021/6/11 0011 - 上午 11:49
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
