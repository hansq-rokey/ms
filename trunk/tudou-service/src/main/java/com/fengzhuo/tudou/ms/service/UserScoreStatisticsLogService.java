package com.fengzhuo.tudou.ms.service;

import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLog;

import java.util.Date;
import java.util.List;

/**
 * Created by hanshuaiqi 19:16 2017/11/6
 */
public interface UserScoreStatisticsLogService {

    List<UserScoreStatisticsLog> queryList();

    UserScoreStatisticsLog selectById(Long id);

    int updateByPrimaryKeySelective(UserScoreStatisticsLog record);
}
