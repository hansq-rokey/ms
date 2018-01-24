package com.fengzhuo.tudou.ms.service.impl;

import com.fengzhuo.tudou.ms.domain.Strategy;
import com.fengzhuo.tudou.ms.persistence.StrategyMapper;
import com.fengzhuo.tudou.ms.service.StrategyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanshuaiqi 19:08 2017/11/6
 */
@Service
public class StrategyServiceImpl implements StrategyService {

    @Resource
    private StrategyMapper strategyMapper;
    @Override
    public List<Strategy> queryList() {
        return strategyMapper.queryList();
    }
}
