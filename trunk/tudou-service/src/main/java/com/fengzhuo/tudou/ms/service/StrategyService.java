package com.fengzhuo.tudou.ms.service;

import com.fengzhuo.tudou.ms.domain.Strategy;

import java.util.List;

/**
 * Created by hanshuaiqi 19:03 2017/11/6
 */
public interface StrategyService {

    /**
     * 查询启用状态的场景
     * @return
     */
    List<Strategy> queryList();
}
