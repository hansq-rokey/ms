package com.fengzhuo.tudou.ms.service.impl;

import com.fengzhuo.tudou.ms.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by hsq 11:07 2018/1/23
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    private static Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class.getName());
    //指定消息目的地的发送方法
    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
    @Override
    public void sendMessage(Destination destination,final String msg){
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+msg);
        logger.info(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+msg);
        jmsTemplate.send(destination,new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    //默认消息目的地的方法
    @Override
    public void sendMessage(final String msg){
        Destination destination = jmsTemplate.getDefaultDestination();
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
        logger.info(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
}
