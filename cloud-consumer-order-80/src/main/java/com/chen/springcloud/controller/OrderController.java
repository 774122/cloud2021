package com.chen.springcloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.chen.springcloud.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author chenhongchang
 * @date 2021/6/4 0004 - 下午 5:45
 */
@RestController
@Slf4j
public class OrderController {
    // public static final  String PAY_MENT_URL = "http://localhost:8001";
    public static final  String PAY_MENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    // 使用自旋锁和求余的方式实现的自定义的 轮询负载均衡
    @Resource
    private MyLoadBalance myLoadBalance;

    @Resource
    private DiscoveryClient discoveryClient;



    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return restTemplate.postForObject(PAY_MENT_URL+"/payment/create", payment, CommonResult.class);
        //return restTemplate.getForEntity(PAY_MENT_URL+"/payment/create", payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAY_MENT_URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getFroEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> entity = restTemplate
                .getForEntity(PAY_MENT_URL+"/payment/get/"+id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"======"+entity.getHeaders());
            return entity.getBody();
        }else{
            return new CommonResult(444, "Ask Failed");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances ==null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = myLoadBalance.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb", String.class);
    }
}
