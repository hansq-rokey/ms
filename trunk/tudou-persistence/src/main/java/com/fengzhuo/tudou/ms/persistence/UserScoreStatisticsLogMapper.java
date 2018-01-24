package com.fengzhuo.tudou.ms.persistence;

import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLog;
import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLogExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserScoreStatisticsLogMapper {
    long countByExample(UserScoreStatisticsLogExample example);

    int deleteByExample(UserScoreStatisticsLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserScoreStatisticsLog record);

    int insertSelective(UserScoreStatisticsLog record);

    List<UserScoreStatisticsLog> selectByExampleWithBLOBs(UserScoreStatisticsLogExample example);

    List<UserScoreStatisticsLog> selectByExample(UserScoreStatisticsLogExample example);

    UserScoreStatisticsLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserScoreStatisticsLog record, @Param("example") UserScoreStatisticsLogExample example);

    int updateByExampleWithBLOBs(@Param("record") UserScoreStatisticsLog record, @Param("example") UserScoreStatisticsLogExample example);

    int updateByExample(@Param("record") UserScoreStatisticsLog record, @Param("example") UserScoreStatisticsLogExample example);

    int updateByPrimaryKeySelective(UserScoreStatisticsLog record);

    int updateByPrimaryKeyWithBLOBs(UserScoreStatisticsLog record);

    int updateByPrimaryKey(UserScoreStatisticsLog record);

    List<UserScoreStatisticsLog> queryAll();
}