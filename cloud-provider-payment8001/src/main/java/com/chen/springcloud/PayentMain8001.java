package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenhongchang
 * @date 2021/6/4 0004 - 下午 3:52
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PayentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayentMain8001.class,args);
    }
}
