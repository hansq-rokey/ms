package com.fengzhuo.tudou.ms.persistence;

import com.fengzhuo.tudou.ms.domain.Strategy;
import com.fengzhuo.tudou.ms.domain.StrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StrategyMapper {
    long countByExample(StrategyExample example);

    int deleteByExample(StrategyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Strategy record);

    int insertSelective(Strategy record);

    List<Strategy> selectByExample(StrategyExample example);

    Strategy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByExample(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByPrimaryKeySelective(Strategy record);

    int updateByPrimaryKey(Strategy record);

    List<Strategy> queryList();
}