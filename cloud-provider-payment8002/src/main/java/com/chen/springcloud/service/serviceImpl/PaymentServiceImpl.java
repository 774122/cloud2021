package com.chen.springcloud.service.serviceImpl;

import com.chen.cloud.entities.Payment;
import com.chen.springcloud.dao.PaymentDao;
import com.chen.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenhongchang
 * @date 2021/6/4 0004 - 下午 4:19
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
