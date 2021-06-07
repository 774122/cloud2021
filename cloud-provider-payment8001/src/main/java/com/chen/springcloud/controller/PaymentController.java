package com.chen.springcloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.chen.springcloud.service.serviceImpl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chenhongchang
 * @date 2021/6/4 0004 - 下午 4:24
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    // 用于 服务做负载均衡时选择端口
    @Value("${server.port}")
    private String serverPort;

    // 用于 服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;  //返回服务接口
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("==========插入结果：" + (result==0 ? "插入失败！": "插入成功！") + "==========");

        if(result > 0){
            return new CommonResult<>(200,"插入数据库成功！serverPort:"+serverPort, result);
        }else return new CommonResult<>(444, "插入数据库失败！", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("==========查询结果：" + payment + "==========");

        if(payment != null){
            return new CommonResult<>(200,"查询成功！serverPort:"+serverPort, payment);
        }else return new CommonResult<>(444, "没有对应记录，查询ID："+id, null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> service = discoveryClient.getServices();
        for(String ele : service){
            log.info("**********"+ ele + "**********");
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance s : instances){
            log.info("==========" + s.getInstanceId()+ "==" + s.getPort() + "===" + s.getUri());
        }

        return this.discoveryClient;
    }

    /**
     * 用于 OpenFeign 的超时控制 设置
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){

        // 暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) { e.printStackTrace(); }

        return serverPort;
    }
}
