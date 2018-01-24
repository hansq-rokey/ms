package com.fengzhuo.tudou.ms.service;

import com.fengzhuo.tudou.ms.domain.LoanStrategyResult;
import com.fengzhuo.tudou.ms.domain.UserScoreStatistics;
import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLog;

/**
 * Created by Admin on 2017/6/21.
 */
public interface LoanStrategyService {

    public LoanStrategyResult execute(
            String name, String phone, String idNo, UserScoreStatistics userScore, String mobileType, String black_box);

    public LoanStrategyResult execute1(
            String name, String phone, String idNo, UserScoreStatisticsLog userScore, String mobileType, String black_box);
}
