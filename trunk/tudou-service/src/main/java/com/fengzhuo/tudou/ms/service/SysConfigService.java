package com.fengzhuo.tudou.ms.service;

import com.fengzhuo.tudou.ms.domain.SysConfig;

import java.util.List;

/**
 * Created by hsq 10:09 2018/1/22
 */
public interface SysConfigService {

    List<SysConfig> flushCache();

    List<SysConfig> findAll();

    SysConfig findByCode(String code);

    SysConfig getSysConfigValue(String key);
}
