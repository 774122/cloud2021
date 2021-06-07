package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenhongchang
 * @date 2021/6/4 0004 - 下午 3:52
 */
@SpringBootApplication
@EnableEurekaClient
public class PayentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayentMain8002.class,args);
    }
}
