package com.chen.springcloud.dao;

import com.chen.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenhongchang
 * @date 2021/6/11 0011 - 下午 9:15
 */
@Mapper
public interface OrderDao {

    // 新建订单
    int create(Order order);

    // 修改订单状态，从 0 -> 1
    int update(@Param("userId") Long userId, @Param("status") Integer status);

}
