package com.chen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenhongchang
 * @date 2021/6/6 0006 - 下午 5:50
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix  // 添加到此处
public class FeignHystrixOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderMain.class,args);
    }
}
