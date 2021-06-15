package com.chen.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chen.cloud.entities.CommonResult;

/**
 * @author chenhongchang
 * @date 2021/6/11 0011 - 上午 9:39
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}
