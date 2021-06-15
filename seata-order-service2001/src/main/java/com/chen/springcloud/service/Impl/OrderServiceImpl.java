package com.chen.springcloud.service.Impl;

import com.chen.springcloud.dao.OrderDao;
import com.chen.springcloud.domain.Order;
import com.chen.springcloud.service.AccountService;
import com.chen.springcloud.service.OrderService;
import com.chen.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenhongchang
 * @date 2021/6/11 0011 - 下午 9:34
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("==========订单微服务开始开始创建 order订单.......");
        orderDao.create(order);

        log.info("==========订单微服务开始  扣减库存........");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("==========订单微服务开始  扣减Money......");
        accountService.decrease(order.getUserId(), order.getMoney());

        // 修改订单状态，从零到一，1代表订单已经完成
        log.info("===========修改订单状态......");
        orderDao.update(order.getUserId(), 0);

        log.info("==========订单结束.....");
    }
}
