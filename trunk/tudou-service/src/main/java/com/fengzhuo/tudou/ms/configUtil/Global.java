package com.fengzhuo.tudou.ms.configUtil;

import com.fengzhuo.tudou.ms.common.StringUtil;
import com.fengzhuo.tudou.ms.domain.SysConfig;
import com.fengzhuo.tudou.ms.service.SysConfigService;
import tool.util.BeanUtil;

import java.util.HashMap;
import java.util.Map;

public class Global {

    protected static Map<String, SysConfig> configMap = new HashMap<String, SysConfig>();
    public static String getValue(String key) {
        return StringUtil.isNull(getObject(key));
    }

    public static Object getObject(String key) {
        SysConfig value = getSysConfig(key);
        if(value == null) {
            value = configMap.get(key);
        }
        if(value != null) {
            return value.getValue();
        }
        return null;
    }

    public static SysConfig getSysConfig(String key) {
        // 系统配置Config缓存
        SysConfigService sysConfigService = (SysConfigService) BeanUtil.getBean("sysConfigService");
        SysConfig value = sysConfigService.getSysConfigValue(key);
        if(value != null) {
            return value;
        }
        return configMap.get(key);
    }

}
