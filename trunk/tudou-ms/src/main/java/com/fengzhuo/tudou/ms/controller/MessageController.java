package com.fengzhuo.tudou.ms.controller;

import com.fengzhuo.tudou.ms.service.ConsumerService;
import com.fengzhuo.tudou.ms.service.ProducerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by hsq 11:13 2018/1/23
 */
@RestController
public class MessageController {
    @Resource
    private ProducerService producerService;
    @Resource
    private ConsumerService consumerService;

    @RequestMapping(value="/sendMessage",method= RequestMethod.GET)
    public void send(String msg) {
        producerService.sendMessage(msg);
    }

    @RequestMapping(value="/receiveMessage",method=RequestMethod.GET)
    public void receive() {
        consumerService.receive();
    }
}
