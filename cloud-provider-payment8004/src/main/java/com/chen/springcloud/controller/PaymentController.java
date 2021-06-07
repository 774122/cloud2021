package com.chen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author chenhongchang
 * @date 2021/6/5 0005 - 下午 5:36
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "SpringCloud with zookeeper: " + serverPort + "======" + UUID.randomUUID().toString();
    }

}
