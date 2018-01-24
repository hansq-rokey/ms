package com.fengzhuo.tudou.ms.service.impl;

import cn.fraudmetrix.riskservice.RuleDetailClient;
import cn.fraudmetrix.riskservice.RuleDetailResult;
import cn.fraudmetrix.riskservice.object.Environment;
import cn.fraudmetrix.riskservice.ruledetail.ConditionDetail;
import cn.fraudmetrix.riskservice.ruledetail.RuleDetail;
import com.alibaba.fastjson.JSON;
import com.fengzhuo.tudou.ms.domain.*;
import com.fengzhuo.tudou.ms.service.LoanStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hanshuaiqi 18:56 2017/11/6
 */
@Service("tongdunRiskService")
public class TongdunRiskServiceImpl implements LoanStrategyService {
    private static final Logger logger = LoggerFactory.getLogger(TongdunRiskServiceImpl.class);
    @Override
    public LoanStrategyResult execute(
            String name, String phone, String idNo, UserScoreStatistics userScore, String mobileType, String black_box) {
        LoanStrategyResult result = new LoanStrategyResult();
        TongdunApiResponse report = this.getReport(name,phone,idNo, black_box, "1".equals(mobileType) ? "ios" : "android");
        logger.info("同盾数据："+report);
        if(report==null || !report.getSuccess()){
            result.setStatus("10");
            result.setScore(-1D);
            userScore.setTongdunScore(BigDecimal.valueOf(-1));
        }else{
            result.setStatus("20");
            result.setScore(Double.valueOf(report.getFinal_score()));
            userScore.setTongdunScore(BigDecimal.valueOf(report.getFinal_score()));
        }
        return result;
    }

    public TongdunApiResponse getReport(String name,String phone,String idNo, String black_box, String app) {
        int count = 0;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("partner_code", GlobalConfig.tdr_partner_code);// 此处值填写您的合作方标识
        params.put("secret_key", "ios".equals(app)?GlobalConfig.tdr_ios_secret_key:GlobalConfig.tdr_android_secret_key);// 此处填写对应app密钥
        params.put("event_id", "ios".equals(app)?GlobalConfig.tdr_ios_loan_id:GlobalConfig.tdr_android_loan_id);// 此处填写策略集上的事件标识
        params.put("black_box", black_box);//此处填写移动端sdk采集到的信息black_box
        params.put("account_name", name);// 以下填写其他要传的参数，比如系统字段，扩展字段
        params.put("account_mobile", phone);
        params.put("id_number", idNo);
        TongdunApiResponse apiResponse = this.invoke(params, GlobalConfig.tdr_path);
        return apiResponse;
    }

    public TongdunApiResponse invoke(Map<String, Object> params, String urlpath) {
        try {
            URL url = new URL(urlpath);
            // 组织请求参数
            StringBuilder postBody = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() == null) continue;
                postBody.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(),
                        "utf-8")).append("&");
            }
            if (!params.isEmpty()) {
                postBody.deleteCharAt(postBody.length() - 1);
            }
            SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            // 设置长链接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置连接超时
            conn.setConnectTimeout(1000);
            // 设置读取超时，建议设置为500ms。若同时调用了信息核验服务，请与客户经理协商确认具体时间
            conn.setReadTimeout(500);
            // 提交参数
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBody.toString().getBytes());
            conn.getOutputStream().flush();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                logger.warn("[FraudApiInvoker] invoke failed, response status:" + responseCode);
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return JSON.parseObject(result.toString().trim(), TongdunApiResponse.class);
        } catch (Exception e) {
            logger.error("[FraudApiInvoker] invoke throw exception, details: " + e);
        }
        return null;
    }

    @Override
    public LoanStrategyResult execute1(
            String name, String phone, String idNo, UserScoreStatisticsLog userScore, String mobileType, String black_box) {
        LoanStrategyResult result = new LoanStrategyResult();
        TongdunApiResponse report = this.getReport(name,phone,idNo, black_box, "1".equals(mobileType) ? "ios" : "android");
        logger.info("同盾数据："+report);
        if(report==null || !report.getSuccess()){
            result.setStatus("10");
            result.setScore(-1D);
            userScore.setTongdunScore(BigDecimal.valueOf(-1));
        }else{
            result.setStatus("20");
            result.setScore(Double.valueOf(report.getFinal_score()));
            userScore.setTongdunScore(BigDecimal.valueOf(report.getFinal_score()));
        }
        return result;
    }
}
