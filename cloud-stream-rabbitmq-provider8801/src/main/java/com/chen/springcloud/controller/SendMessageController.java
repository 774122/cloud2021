package com.chen.springcloud.controller;

import com.chen.springcloud.service.Impl.IMessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenhongchang
 * @date 2021/6/8 0008 - 下午 4:13
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProviderImpl iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
