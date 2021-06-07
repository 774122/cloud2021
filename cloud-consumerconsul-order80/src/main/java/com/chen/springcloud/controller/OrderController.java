package com.chen.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chenhongchang
 * @date 2021/6/5 0005 - 下午 6:49
 */
@RestController
public class OrderController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    //@Value("${server.port}")
    //private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/consul/order")
    public String paymentOrder(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul", String.class);
    }
}
