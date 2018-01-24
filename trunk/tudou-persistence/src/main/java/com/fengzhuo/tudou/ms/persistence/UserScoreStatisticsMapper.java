package com.fengzhuo.tudou.ms.persistence;

import com.fengzhuo.tudou.ms.domain.UserScoreStatistics;
import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserScoreStatisticsMapper {
    long countByExample(UserScoreStatisticsExample example);

    int deleteByExample(UserScoreStatisticsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserScoreStatistics record);

    int insertSelective(UserScoreStatistics record);

    List<UserScoreStatistics> selectByExampleWithBLOBs(UserScoreStatisticsExample example);

    List<UserScoreStatistics> selectByExample(UserScoreStatisticsExample example);

    UserScoreStatistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserScoreStatistics record, @Param("example") UserScoreStatisticsExample example);

    int updateByExampleWithBLOBs(@Param("record") UserScoreStatistics record, @Param("example") UserScoreStatisticsExample example);

    int updateByExample(@Param("record") UserScoreStatistics record, @Param("example") UserScoreStatisticsExample example);

    int updateByPrimaryKeySelective(UserScoreStatistics record);

    int updateByPrimaryKeyWithBLOBs(UserScoreStatistics record);

    int updateByPrimaryKey(UserScoreStatistics record);
}