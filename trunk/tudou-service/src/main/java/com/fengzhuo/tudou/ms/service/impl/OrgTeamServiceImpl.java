package com.fengzhuo.tudou.ms.service.impl;

import com.fengzhuo.tudou.ms.domain.OrgTeam;
import com.fengzhuo.tudou.ms.persistence.OrgTeamMapper;
import com.fengzhuo.tudou.ms.service.OrgTeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hanshuaiqi 15:00 2017/11/10
 */
@Service
public class OrgTeamServiceImpl implements OrgTeamService {
    @Resource
    private OrgTeamMapper orgTeamMapper;
    @Override
    public OrgTeam getTeamByNo(String teamNo) {
        return orgTeamMapper.getTeamByNo(teamNo);
    }
}
