package com.fengzhuo.tudou.ms.service.impl;

import com.fengzhuo.tudou.ms.domain.LoanStrategyResult;
import com.fengzhuo.tudou.ms.domain.UserScoreStatistics;
import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLog;
import com.fengzhuo.tudou.ms.service.LoanStrategyService;
import org.springframework.stereotype.Service;

/**
 * Created by hanshuaiqi 9:55 2017/11/7
 */
@Service("borrowTimesService")
public class BorrowTimesServiceImpl implements LoanStrategyService{
    @Override
    public LoanStrategyResult execute(String name, String phone, String idNo, UserScoreStatistics userScore, String mobileType, String black_box) {
        return new LoanStrategyResult();
    }

    @Override
    public LoanStrategyResult execute1(String name, String phone, String idNo, UserScoreStatisticsLog userScore, String mobileType, String black_box) {
        return new LoanStrategyResult();
    }
}
