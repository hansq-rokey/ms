package com.fengzhuo.tudou.ms.service.impl;

import cn.freesoft.utils.FsUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fengzhuo.tudou.ms.common.StringUtil;
import com.fengzhuo.tudou.ms.domain.GlobalConfig;
import com.fengzhuo.tudou.ms.domain.LoanStrategyResult;
import com.fengzhuo.tudou.ms.domain.UserScoreStatistics;
import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLog;
import com.fengzhuo.tudou.ms.service.LoanStrategyService;
import com.fengzhuo.tudou.ms.util.ppx.HttpsRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanshuaiqi 18:59 2017/11/6
 */
@Service("ppCreditService")
public class PpCreditServiceImpl implements LoanStrategyService {
    public static final Logger logger = LoggerFactory.getLogger(PpCreditServiceImpl.class);
    @Override
    public LoanStrategyResult execute(String name, String phone, String idNo,
                                      UserScoreStatistics userScore, String mobileType, String black_box) {
        LoanStrategyResult result = new LoanStrategyResult();
        String report = ppcredit(name,idNo,phone);
        if(StringUtil.isEmpty(report)){
            result.setStatus("10");
            result.setScore(-1D);
            userScore.setPpxScore(BigDecimal.valueOf(-1));
            return result;
        }else{
            JSONObject jsonObject = JSON.parseObject(report);
            JSONObject respBody = jsonObject.getJSONObject("resp_body");
            String ret = respBody.getString("result");
            //查询成功
            if (ret.equals("success")) {
                JSONObject msg = respBody.getJSONObject("msg");
                JSONObject queryResults = msg.getJSONObject("mjReport").getJSONObject("queryResults");
                //查询成功有数据
                if (queryResults.getString("isBlack").equals("1")) {
                    result.setScore(1D);//黑名单
                    userScore.setPpxScore(BigDecimal.valueOf(1));
                } else {
                    result.setScore(0D);
                    userScore.setPpxScore(BigDecimal.valueOf(0));
                }
                result.setStatus("20");
                logger.info("拍拍验证结果:" + phone + "用户" + (result.getScore()==1?"是否命中拍拍黑名单:是":"是否命中拍拍黑名单:否"));
            } else {
                //查询失败或发生异常
                result.setScore(-1D);
                userScore.setPpxScore(BigDecimal.valueOf(-1));
                result.setStatus("10");
                String errorMsg = respBody.getJSONObject("msg").getString("msg");
                if (FsUtils.strsEmpty(errorMsg)) {
                    errorMsg = jsonObject.getString("resp_msg");
                }
                logger.error("用户" + phone + "查询失败的原因是:" + errorMsg);
            }
            return result;
        }
    }

    public String ppcredit(String name,String idNo,String phone) {
        try {
            String method = "risklist.query";
            Map<String, String> map = new HashMap<>();
            map.put("name", name);
            map.put("idNumber", idNo);
            map.put("mobile", phone);
            String ll = HttpsRequestUtil.post(map, method, GlobalConfig.pp_appkey,
                    GlobalConfig.pp_appSecret);
            logger.info("用户" + phone + "的拍拍档查询结果是" + ll);
            return ll;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取拍拍档数据错误,", e);
        }
        return null;
    }

    @Override
    public LoanStrategyResult execute1(String name, String phone, String idNo,
                                       UserScoreStatisticsLog userScore, String mobileType, String black_box) {
        LoanStrategyResult result = new LoanStrategyResult();
        String report = ppcredit(name,idNo,phone);
        if(StringUtil.isEmpty(report)){
            result.setStatus("10");
            result.setScore(-1D);
            userScore.setPpxScore(BigDecimal.valueOf(-1));
            return result;
        }else{
            JSONObject jsonObject = JSON.parseObject(report);
            JSONObject respBody = jsonObject.getJSONObject("resp_body");
            String ret = respBody.getString("result");
            //查询成功
            if (ret.equals("success")) {
                JSONObject msg = respBody.getJSONObject("msg");
                JSONObject queryResults = msg.getJSONObject("mjReport").getJSONObject("queryResults");
                //查询成功有数据
                if (queryResults.getString("isBlack").equals("1")) {
                    result.setScore(1D);//黑名单
                    userScore.setPpxScore(BigDecimal.valueOf(1));
                } else {
                    result.setScore(0D);
                    userScore.setPpxScore(BigDecimal.valueOf(0));
                }
                result.setStatus("20");
                logger.info("拍拍验证结果:" + phone + "用户" + (result.getScore()==1?"是否命中拍拍黑名单:是":"是否命中拍拍黑名单:否"));
            } else {
                //查询失败或发生异常
                result.setScore(-1D);
                userScore.setPpxScore(BigDecimal.valueOf(-1));
                result.setStatus("10");
                String errorMsg = respBody.getJSONObject("msg").getString("msg");
                if (FsUtils.strsEmpty(errorMsg)) {
                    errorMsg = jsonObject.getString("resp_msg");
                }
                logger.error("用户" + phone + "查询失败的原因是:" + errorMsg);
            }
            return result;
        }
    }
}
