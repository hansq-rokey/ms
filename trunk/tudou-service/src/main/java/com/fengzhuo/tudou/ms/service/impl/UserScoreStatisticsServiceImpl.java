package com.fengzhuo.tudou.ms.service.impl;

import com.fengzhuo.tudou.ms.domain.UserScoreStatistics;
import com.fengzhuo.tudou.ms.persistence.UserScoreStatisticsMapper;
import com.fengzhuo.tudou.ms.service.UserScoreStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hanshuaiqi 19:16 2017/11/6
 */
@Service
public class UserScoreStatisticsServiceImpl implements UserScoreStatisticsService {

    @Resource
    private UserScoreStatisticsMapper userScoreStatisticsMapper;
    @Override
    public int insertSelective(UserScoreStatistics record) {
        return userScoreStatisticsMapper.insertSelective(record);
    }
}
