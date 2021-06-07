package com.chen.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenhongchang
 * @date 2021/6/6 0006 - 上午 9:27
 */
@Component
public class MyLB implements MyLoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 计算 请求次数，每次自增
     * @return 服务列表的索引，表示使用该服务
     */
    public final  int getAndIncreament(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current>=2147483647 ? 0 : current+1;

        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*****当前是第几次：next：" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {

        int index = getAndIncreament() % instances.size();

        return instances.get(index);
    }
}
