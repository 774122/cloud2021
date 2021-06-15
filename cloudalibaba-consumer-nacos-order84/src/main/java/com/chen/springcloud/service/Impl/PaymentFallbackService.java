package com.chen.springcloud.service.Impl;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.chen.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author chenhongchang
 * @date 2021/6/11 0011 - 上午 11:51
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",
                                    new Payment(id,"errorSerial"));
    }
}
