package com.fengzhuo.tudou.ms.service;

import javax.jms.TextMessage;

/**
 * Created by hsq 11:07 2018/1/23
 */
public interface ConsumerService {

    TextMessage receive();
}
