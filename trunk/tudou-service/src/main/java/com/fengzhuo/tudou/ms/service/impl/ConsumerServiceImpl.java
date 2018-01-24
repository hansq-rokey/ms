package com.fengzhuo.tudou.ms.service.impl;

import com.fengzhuo.tudou.ms.service.ConsumerService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by hsq 11:08 2018/1/23
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    //消息目的地
    @Resource(name = "demoQueueDestination")
    Destination destination;

    @Resource(name="jmsTemplate")
    JmsTemplate jmsTemplate;

    /**
     * 消费消息，如果配置监听器，监听器消费了，消息就在队列中不存在，这里的手动消费就失败了（textMessage=null）
     * @return
     */
    @Override
    public TextMessage receive() {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive();
        try{
            System.out.println("从队列" + destination+ "收到了消息：\t"
                    + textMessage.getText().toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return textMessage;
    }
}
