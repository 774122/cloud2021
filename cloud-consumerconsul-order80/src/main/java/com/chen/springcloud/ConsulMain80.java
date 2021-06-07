package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenhongchang
 * @date 2021/6/5 0005 - 下午 7:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulMain80.class,args);
    }
}
