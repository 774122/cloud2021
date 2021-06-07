package com.chen.springcloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.chen.springcloud.service.serviceImpl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenhongchang
 * @date 2021/6/4 0004 - 下午 4:24
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("==========插入结果：" + (result==0 ? "插入失败！": "插入成功！") + "==========");

        if(result > 0){
            return new CommonResult<>(200,"插入数据库成功！serverPort: "+serverPort, result);
        }else return new CommonResult<>(444, "插入数据库失败！", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("==========插入结果：" + payment + "==========");

        if(payment != null){
            return new CommonResult<>(200,"查询成功8002！serverPort: "+serverPort, payment);
        }else return new CommonResult<>(444, "没有对应记录，查询ID："+id, null);
    }
}
