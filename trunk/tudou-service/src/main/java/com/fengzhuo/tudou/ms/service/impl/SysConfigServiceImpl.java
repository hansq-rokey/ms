package com.fengzhuo.tudou.ms.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengzhuo.tudou.ms.domain.SysConfig;
import com.fengzhuo.tudou.ms.jedis.JedisClient;
import com.fengzhuo.tudou.ms.persistence.SysConfigMapper;
import com.fengzhuo.tudou.ms.service.SysConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hsq 10:09 2018/1/22
 */
@Service("sysConfigService")
public class SysConfigServiceImpl implements SysConfigService{
    @Resource
    private JedisClient jedisClient;
    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public SysConfig findByCode(String code){
        return sysConfigMapper.findByCode(code);
    }

    @Override
    public List<SysConfig> flushCache() {
        List<SysConfig> sysConfigs = findAll();

        for (SysConfig sysConfig : sysConfigs) {
            updateCache(sysConfig);
        }
        return null;
    }

    @Override
    public List<SysConfig> findAll() {
        return sysConfigMapper.findAll();
    }

    @Override
    public SysConfig getSysConfigValue(String code) {
        SysConfig sysConfig;
        String value = (String)jedisClient.hget("global:sysConfig", code);
        if(value == null) {
            sysConfig = findByCode(code);
            if(sysConfig != null) {
                updateCache(sysConfig);
            }
        } else {
            sysConfig = JSON.parseObject(value, SysConfig.class);
        }
        return sysConfig;
    }

    private void updateCache(SysConfig sysConfig) {
        String jsonString = JSON.toJSONString(sysConfig);
        jedisClient.hset("global:sysConfig", sysConfig.getCode(), jsonString);
    }
}
