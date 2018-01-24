package com.fengzhuo.tudou.ms.common;

import java.util.HashMap;
import java.util.Map;

public class ResultUtil {
    public final static Map<String, Object> genSuccessResult() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("msg", "success");
        return map;
    }

    public final static Map<String, Object> genSuccessResult(Object data) {
        Map<String, Object> map = genSuccessResult();
        map.put("result", data);
        map.put("msg", "success");
        map.put("code", 200);
        return map;
    }

    public final static Map<String, Object> genFailedResult(int code, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

    public final static Map<String, Object> genFailedResult(int code, String msg, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("result", data);
        return map;
    }
}
