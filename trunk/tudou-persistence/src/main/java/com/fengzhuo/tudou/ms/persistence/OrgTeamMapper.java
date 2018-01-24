package com.fengzhuo.tudou.ms.persistence;

import com.fengzhuo.tudou.ms.domain.OrgTeam;
import com.fengzhuo.tudou.ms.domain.OrgTeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgTeamMapper {
    long countByExample(OrgTeamExample example);

    int deleteByExample(OrgTeamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgTeam record);

    int insertSelective(OrgTeam record);

    List<OrgTeam> selectByExample(OrgTeamExample example);

    OrgTeam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgTeam record, @Param("example") OrgTeamExample example);

    int updateByExample(@Param("record") OrgTeam record, @Param("example") OrgTeamExample example);

    int updateByPrimaryKeySelective(OrgTeam record);

    int updateByPrimaryKey(OrgTeam record);

    OrgTeam getTeamByNo(String teamNo);
}