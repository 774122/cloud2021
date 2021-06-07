package com.chen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author chenhongchang
 * @date 2021/6/5 0005 - 下午 7:25
 */
@RestController
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "SpringCloud with Consul: " + serverPort + "======" + UUID.randomUUID().toString();
    }
}
