package com.fengzhuo.tudou.ms.service.impl;

import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLog;
import com.fengzhuo.tudou.ms.persistence.UserScoreStatisticsLogMapper;
import com.fengzhuo.tudou.ms.service.UserScoreStatisticsLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by hanshuaiqi 19:16 2017/11/6
 */
@Service
public class UserScoreStatisticsLogServiceImpl implements UserScoreStatisticsLogService {
    @Resource
    private UserScoreStatisticsLogMapper userScoreStatisticsLogMapper;

    @Override
    public List<UserScoreStatisticsLog> queryList() {
        return userScoreStatisticsLogMapper.queryAll();
    }

    @Override
    public UserScoreStatisticsLog selectById(Long id) {
        return userScoreStatisticsLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserScoreStatisticsLog record) {
        return userScoreStatisticsLogMapper.updateByPrimaryKeySelective(record);
    }
}
