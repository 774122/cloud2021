package com.chen.springcloud.controller;

import com.chen.springcloud.domain.CommonResult;
import com.chen.springcloud.domain.Order;
import com.chen.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenhongchang
 * @date 2021/6/11 0011 - 下午 10:03
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);

        return new CommonResult(200, "创建订单成功！");
    }

}
