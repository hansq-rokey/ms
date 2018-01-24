package com.fengzhuo.tudou.ms.exeception;

import com.fengzhuo.tudou.ms.common.ErrorCode;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MsExceptionResolver implements HandlerExceptionResolver {
    private final static Logger log = Logger.getLogger(MsExceptionResolver.class);

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            log.error("server unknow error", ex);
            response.getWriter().print("{\"code\":" + ErrorCode.UNKNOW_ERR + ", \"errorMsg\":\"unknow error\"}");
        } catch (IOException e) {
        }
        return new ModelAndView();
    }
}
