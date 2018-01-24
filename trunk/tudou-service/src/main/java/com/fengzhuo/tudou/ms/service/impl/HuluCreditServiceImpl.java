package com.fengzhuo.tudou.ms.service.impl;

import cn.freesoft.utils.FsUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fengzhuo.tudou.ms.common.StringUtil;
import com.fengzhuo.tudou.ms.domain.GlobalConfig;
import com.fengzhuo.tudou.ms.domain.LoanStrategyResult;
import com.fengzhuo.tudou.ms.domain.UserScoreStatistics;
import com.fengzhuo.tudou.ms.domain.UserScoreStatisticsLog;
import com.fengzhuo.tudou.ms.jedis.JedisClient;
import com.fengzhuo.tudou.ms.service.LoanStrategyService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.math.BigDecimal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by hanshuaiqi 18:54 2017/11/6
 */
@Service("huluCreditService")
public class HuluCreditServiceImpl implements LoanStrategyService {
    public static final Logger logger = LoggerFactory.getLogger(HuluCreditServiceImpl.class);

    @Resource
    private JedisClient jedisClient;
    @Override
    public LoanStrategyResult execute(String name, String phone, String idNo,
                                      UserScoreStatistics userScore, String mobileType, String black_box) {
        LoanStrategyResult result = new LoanStrategyResult();
        String token = getToken();
        if (FsUtils.strsEmpty(token)) {
            result.setScore(-1D);
            result.setStatus("10");
            userScore.setHuluScore(BigDecimal.valueOf(-1));
            return result;
        }
        String company = GlobalConfig.hulu_company;
        String url = "https://ad.hulushuju.com/api/sauron?name=" + name + "&phone="
                + phone + "&idCard=" + idNo + "&companyAccount=" + company + "&accessToken="
                + token;
        String ctx = get(url);
        if (FsUtils.strsEmpty(ctx) || StringUtil.isEmpty(ctx)) {
            result.setScore(-1D);
            result.setStatus("10");
            userScore.setHuluScore(BigDecimal.valueOf(-1));
            return result;
        }
        JSONObject json = JSON.parseObject(ctx);
        logger.info("用户"+phone+"葫芦数据："+JSONObject.toJSONString(json));
        if (17153 == json.getInteger("code")) {
            JSONObject data = json.getJSONObject("data");
            try {
                JSONObject risk = data.getJSONObject("risk_social_network");
                String score = risk.getString("sn_score");
                if (FsUtils.strsEmpty(score)) {
                    score = "0";
                }
                result.setScore(Double.parseDouble(score));
                userScore.setHuluScore(BigDecimal.valueOf(Double.parseDouble(score)));
                result.setStatus("20");
            } catch (Exception ex) {
                FsUtils.log_error(ex);
            }
        } else {
            result.setScore(-1D);
            result.setStatus("10");
            userScore.setHuluScore(BigDecimal.valueOf(-1));
        }
        return result;
    }

    private String getToken() {
        String company = GlobalConfig.hulu_company;
        String sign = GlobalConfig.hulu_sign;
        String key = "mshulu:"+company;
        if (jedisClient.get(key)!=null) {
            return jedisClient.get(key);
        }
        String url = "https://data.hulushuju.com/api/companies/" + company + "/access_token?signature=" + sign;
        String ret = get(url);
        JSONObject json = JSON.parseObject(ret);
        int code = json.getInteger("code");
        if (0 == code) {
            JSONObject jsonObject = json.getJSONObject("data");
            String token = jsonObject.getString("access_token");
            jedisClient.setex(key,token,3*60);
            return token;
        }
        return "";
    }
    private String get(String url) {
        try {
            DefaultHttpClient httpClient = new SSLClient();
            HttpGet get = new HttpGet(url);
            HttpResponse response = httpClient.execute(get);
            /* 发送请求并等待响应 */
            /* 若状态码为200 ok */
            if (response.getStatusLine().getStatusCode() == 200) {
                /* 读返回数据 */
                String strResult = EntityUtils.toString(response.getEntity(), "UTF-8");
                return strResult;
            } else {
                return "";
            }
        } catch (Exception e) {
            FsUtils.log_error(e);
        }
        return "";
    }
    public class SSLClient extends DefaultHttpClient {
        public SSLClient() throws Exception {
            super();
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            ClientConnectionManager ccm = this.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", 443, ssf));
        }
    }

    @Override
    public LoanStrategyResult execute1(String name, String phone, String idNo, UserScoreStatisticsLog userScore, String mobileType, String black_box) {
        LoanStrategyResult result = new LoanStrategyResult();
        String token = getToken();
        if (FsUtils.strsEmpty(token)) {
            result.setScore(-1D);
            result.setStatus("10");
            userScore.setHuluScore(BigDecimal.valueOf(-1));
            return result;
        }
        String company = GlobalConfig.hulu_company;
        String url = "https://ad.hulushuju.com/api/sauron?name=" + name + "&phone="
                + phone + "&idCard=" + idNo + "&companyAccount=" + company + "&accessToken="
                + token;
        String ctx = get(url);
        if (FsUtils.strsEmpty(ctx) || StringUtil.isEmpty(ctx)) {
            result.setScore(-1D);
            result.setStatus("10");
            userScore.setHuluScore(BigDecimal.valueOf(-1));
            return result;
        }
        JSONObject json = JSON.parseObject(ctx);
        logger.info("用户"+phone+"葫芦数据："+JSONObject.toJSONString(json));
        if (17153 == json.getInteger("code")) {
            JSONObject data = json.getJSONObject("data");
            try {
                JSONObject risk = data.getJSONObject("risk_social_network");
                String score = risk.getString("sn_score");
                if (FsUtils.strsEmpty(score)) {
                    score = "0";
                }
                result.setScore(Double.parseDouble(score));
                userScore.setHuluScore(BigDecimal.valueOf(Double.parseDouble(score)));
                result.setStatus("20");
            } catch (Exception ex) {
                FsUtils.log_error(ex);
            }
        } else {
            result.setScore(-1D);
            result.setStatus("10");
            userScore.setHuluScore(BigDecimal.valueOf(-1));
        }
        return result;
    }
}
