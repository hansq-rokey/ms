package com.fengzhuo.tudou.ms.service.impl;

import cn.freesoft.utils.FsUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fengzhuo.tudou.ms.common.StringUtil;
import com.fengzhuo.tudou.ms.domain.LoanStrategyResult;
import com.fengzhuo.tudou.ms.domain.UserScoreStatistics;
import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLog;
import com.fengzhuo.tudou.ms.jedis.JedisClient;
import com.fengzhuo.tudou.ms.service.LoanStrategyService;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanshuaiqi 18:56 2017/11/6
 */
@Service("ucreditService")
public class UcreditServiceImpl implements LoanStrategyService{
    public static final Logger logger = LoggerFactory.getLogger(UcreditServiceImpl.class);
    @Resource
    private JedisClient jedisClient;
    @Override
    public LoanStrategyResult execute(String name, String phone, String idNo, UserScoreStatistics userScore, String mobileType, String black_box) {
        LoanStrategyResult result = new LoanStrategyResult();
        String ret = youdun(name,phone,idNo);
        if(StringUtil.isEmpty(ret)){
            result.setStatus("10");
            result.setScore(-1D);
            userScore.setUdScore(BigDecimal.valueOf(-1));
            return result;
        }
        JSONObject json = JSON.parseObject(ret);
        JSONObject header = json.getJSONObject("header");
        if (header.getString("ret_code").equals("000000")) {
            int ret_score = json.getJSONObject("body").getJSONObject("scores").getInteger("MODEL1");
            result.setScore(Double.valueOf(ret_score));
            userScore.setUdScore(BigDecimal.valueOf(ret_score));
            result.setStatus("20");
        } else {
            result.setStatus("10");
            result.setScore(-1D);
            userScore.setUdScore(BigDecimal.valueOf(-1));
        }
        return result;
    }

    public String youdun(String name,String phone,String idNo) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("id_no", idNo);
            map.put("id_name", name);
            map.put("mobile", phone);
            map.put("version", "2.0");
            String key="id_no:"+idNo+":name:"+name+":mobile:"+phone;
            if(jedisClient.get(key)!=null){
                return jedisClient.get(key);
            }
            String result = apiCall("https://api4.udcredit.com", "fb46dd17-497d-45a3-bfba-d54a18cff919",
                    "e1e9bf1d-5eb5-404f-8ef4-7fd2dc260cbf", "M1001002", System.currentTimeMillis() + " ", map);
            FsUtils.log_info("有盾结果："+result);
            jedisClient.setex(key,result,120);
            return result;
        } catch (Exception e) {
            logger.error("youdun", e);
        }
        return "";
    }
    private String fformatStr =
            "https://api4.udcredit.com/dsp-front/4.1/dsp-front/default/pubkey/%s/product_code/%s/out_order_id/%s/signature/%s";

    public String apiCall(String url, String pubkey, String secretkey, String serviceCode, String outOrderId,
                          Map<String, String> parameter) throws Exception {

        if (parameter == null || parameter.isEmpty())
            throw new Exception("error ! the parameter Map can't be null.");

        StringBuffer bodySb = new StringBuffer("{");
        for (Map.Entry<String, String> entry : parameter.entrySet()) {
            bodySb.append("'").append(entry.getKey()).append("':'").append(entry.getValue()).append("',");
        }
        String bodyStr = bodySb.substring(0, bodySb.length() - 1) + "}";
        String signature = md5(bodyStr + "|" + secretkey);
        url = String.format(fformatStr, pubkey, serviceCode, System.currentTimeMillis() + " ", signature);
        logger.info("requestUrl=>" + url);
        logger.info("request parameter body=>" + bodyStr);
        HttpResponse r = makePostRequest(url, bodyStr);
        return EntityUtils.toString(r.getEntity());
    }

    private final CloseableHttpClient client = HttpClientBuilder.create().build();

    private HttpResponse makePostRequest(String uri, String jsonData)
            throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(URIUtil.encodeQuery(uri, "utf-8"));
        httpPost.setEntity(new StringEntity(jsonData, "UTF-8"));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json; charset=utf-8");
        return client.execute(httpPost);
    }

    private String md5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.toString().getBytes());
        return bytesToHex(md.digest());
    }

    private String bytesToHex(byte[] ch) {
        StringBuffer ret = new StringBuffer("");
        for (int i = 0; i < ch.length; i++)
            ret.append(byteToHex(ch[i]));
        return ret.toString();
    }
    /**
     * 字节转换16进制字符
     */
    private String byteToHex(byte ch) {
        String str[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        return str[ch >> 4 & 0xF] + str[ch & 0xF];
    }

    @Override
    public LoanStrategyResult execute1(String name, String phone, String idNo, UserScoreStatisticsLog userScore, String mobileType, String black_box) {
        LoanStrategyResult result = new LoanStrategyResult();
        String ret = youdun(name,phone,idNo);
        if(StringUtil.isEmpty(ret)){
            result.setStatus("10");
            result.setScore(-1D);
            userScore.setUdScore(BigDecimal.valueOf(-1));
            return result;
        }
        JSONObject json = JSON.parseObject(ret);
        JSONObject header = json.getJSONObject("header");
        if (header.getString("ret_code").equals("000000")) {
            int ret_score = json.getJSONObject("body").getJSONObject("scores").getInteger("MODEL1");
            result.setScore(Double.valueOf(ret_score));
            userScore.setUdScore(BigDecimal.valueOf(ret_score));
            result.setStatus("20");
        } else {
            result.setStatus("10");
            result.setScore(-1D);
            userScore.setUdScore(BigDecimal.valueOf(-1));
        }
        return result;
    }
}
