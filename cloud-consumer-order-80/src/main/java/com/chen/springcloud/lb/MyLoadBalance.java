package com.chen.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author chenhongchang
 * @date 2021/6/6 0006 - 上午 9:29
 */
public interface MyLoadBalance {
    ServiceInstance instance(List<ServiceInstance> instances);
}
