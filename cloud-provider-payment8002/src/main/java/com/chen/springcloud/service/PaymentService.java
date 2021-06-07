package com.chen.springcloud.service;

import com.chen.cloud.entities.Payment;

/**
 * @author chenhongchang
 * @date 2021/6/4 0004 - 下午 4:18
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
