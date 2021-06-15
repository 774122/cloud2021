package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author chenhongchang
 * @date 2021/6/8 0008 - 上午 9:44
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMain3344.class,args);
    }
}
