package com.fengzhuo.tudou.ms.service.impl;

import com.fengzhuo.tudou.ms.common.ReflectUtil;
import com.fengzhuo.tudou.ms.domain.GlobalConfig;
import com.fengzhuo.tudou.ms.domain.SysConfig;
import com.fengzhuo.tudou.ms.domain.SysConfigExample;
import com.fengzhuo.tudou.ms.persistence.SysConfigMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class OnStart {
    private final static Logger log = Logger.getLogger(OnStart.class);
    @Resource
    private SysConfigMapper sysConfigMapper;

    @PostConstruct
    public void onStart() {
        List<SysConfig> sysConfigList = sysConfigMapper.selectByExample(new SysConfigExample());
        for (SysConfig sysConfig : sysConfigList) {
            ReflectUtil.setValue(GlobalConfig.class, null, sysConfig.getCode(), sysConfig.getValue());
        }
        log.info("success load sysconfig");
    }
}
