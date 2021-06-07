package com.chen.springcloud.controller;

import com.chen.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenhongchang
 * @date 2021/6/6 0006 - 下午 5:55
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK_order(@PathVariable("id") Integer id){

        String result = service.paymentInfo_OK(id);
        return result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })*/
    @HystrixCommand  // 使用全局 fallback方法
    String paymentInfo_TimeOut_order(@PathVariable("id") Integer id){

        String result = service.paymentInfo_TimeOut(id);
        return result;
    }
    //善后方法  fallback 方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80 ,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己 ,o(╥﹏╥)o";
    }

    // 全局 fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
