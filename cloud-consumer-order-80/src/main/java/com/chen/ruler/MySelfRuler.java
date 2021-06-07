package com.chen.ruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenhongchang
 * @date 2021/6/6 0006 - 上午 8:28
 */
@Configuration
public class MySelfRuler {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
