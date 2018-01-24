package com.fengzhuo.tudou.ms.service;

import javax.jms.Destination;

/**
 * Created by hsq 11:06 2018/1/23
 */
public interface ProducerService {

    void sendMessage(Destination destination, final String msg);

    void sendMessage(final String msg);
}
