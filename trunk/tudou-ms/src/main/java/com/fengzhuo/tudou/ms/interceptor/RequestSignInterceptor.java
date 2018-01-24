package com.fengzhuo.tudou.ms.interceptor;

import com.fengzhuo.tudou.ms.common.ErrorCode;
import com.fengzhuo.tudou.ms.common.MapUtil;
import com.fengzhuo.tudou.ms.common.StringUtil;
import com.fengzhuo.tudou.ms.domain.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.codec.Hex;
/**
 * Created by hanshuaiqi 14:59 2017/11/6
 */
public class RequestSignInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestSignInterceptor.class);
    /**
     * 内部服务专用
     */
    private static final String SERVICETOKEN = "08b1f35566bd48078b29b95536bceb64";
    @Resource
    private AppConfig appConfig;

    public static Map<String, Object> getParams(HttpServletRequest request) {
        Map<String, String[]> rec = request.getParameterMap();
        Map<String, Object> result = new LinkedHashMap<String, Object>();

        for (Map.Entry<String, String[]> entry : rec.entrySet()) {
            String name = entry.getKey();
            Object value = entry.getValue()[0];
            result.put(name, value);
        }
        return result;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        logger.debug("req uri: {}", uri);

        String token = request.getHeader("token");
        String signMsg = request.getHeader("signMsg");

        if (SERVICETOKEN.equals(token)) {
            return true;
        }
        Map<String, Object> requestMap = getParams(request);
        String _signMsg;
        boolean flag;
        if (StringUtil.isEmpty(signMsg)) {
            response.getWriter().print("{\"code\":" + ErrorCode.FAIL + ", \"msg\":\"signMsg is null\"}");
            logger.info("{\"code\":" + ErrorCode.FAIL + ", \"msg\":\"signMsg is null\"}");
            return false;
        }
        _signMsg = md5(appConfig.getSignKey() + (token == null?"" : token)+paramsString(requestMap));
        flag = _signMsg.equalsIgnoreCase(signMsg);
        // 开发环境不校验签名
        if (appConfig.getEnv()!=1){
            if (!flag) {
                logger.info("app sign is: {}, but server sign is: {}", signMsg, _signMsg);
                logger.info("params:"+paramsString(requestMap));
                response.getWriter().print("{\"code\":" + ErrorCode.FAIL + ", \"msg\":\"signMsg is error\"}");
                logger.info("{\"code\":" + ErrorCode.FAIL + ", \"msg\":\"signMsg is error\"}");
                return false;
            }
        }
        return true;
    }
    public static String paramsString(Map<String, Object> map) {
        Map<String, Object> rec = MapUtil.simpleSort(map);
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Object> entry : rec.entrySet()) {
            String name = entry.getKey();
            Object value = entry.getValue();
            sb.append(name + "=" + value).append("|");
        }
        if (sb.length() > 1)
            sb.deleteCharAt(sb.length() - 1);
        logger.debug("签名验签" + sb.toString());
        return sb.toString();
    }

    private static String md5(String data) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        return Hex.encodeToString(MessageDigest.getInstance("MD5").digest(
                data.getBytes("utf8")));
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
