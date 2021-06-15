package com.chen.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenhongchang
 * @date 2021/6/11 0011 - 下午 10:07
 */
@Configuration
@MapperScan("com.chen.springcloud.dao")
public class MyBatiseConfig {
}
