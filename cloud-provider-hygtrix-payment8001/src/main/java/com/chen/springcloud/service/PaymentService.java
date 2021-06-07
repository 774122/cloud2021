package com.chen.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author chenhongchang
 * @date 2021/6/6 0006 - 下午 12:29
 */
@Service
public class PaymentService {

    public String paymentInfo(Integer id){
        return "线程池： " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfoTimeOut(Integer id){

        int timeout = 2;
        // int age = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() +
                " paymentInfoTimeOut, id: " + id + "  耗时 " + timeout + " 秒";
    }
    public String paymentInfo_TimeoutHandler(Integer id){

        return "线程池： " + Thread.currentThread().getName() +
                " paymentInfo_TimeoutHandler, 系统忙，请稍后再试 , id: " + id + "  o(╥﹏╥)o";
    }


    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            // 在时间窗内，必须满足请求总数阈值才有资格熔断，默认20，即在 10秒内，若该hystrix命令的调用次数
            // 不足 20次，那么即使所有的请求都超时或者其他原因失败，断路器都不会打开
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            // 断路器是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近 10 秒
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
