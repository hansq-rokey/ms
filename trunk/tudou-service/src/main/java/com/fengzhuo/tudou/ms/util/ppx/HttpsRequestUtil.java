package com.fengzhuo.tudou.ms.util.ppx;

import com.fengzhuo.tudou.ms.domain.GlobalConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * httpclient4.0以上
 *
 */
public class HttpsRequestUtil {
	
	private static HttpClientBuilder buildHttpClient(BasicCookieStore cookieStore, String url) throws Exception {
		HttpClientBuilder httpBuilder =  HttpClientBuilder.create().setDefaultCookieStore(cookieStore);
		if (StringUtils.startsWith(url, "https")) {
			SSLContext sslcontext = SSLContext.getInstance("TLSv1.2");
			sslcontext.init(null, new TrustManager[] { new X509TrustManager() {

				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[] {};
				}

				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

				}

				@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

				}
			} }, new java.security.SecureRandom());
			SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslcontext,
					new String[] { "TLSv1", "SSLv3" }, null, new HostnameVerifier() {

						@Override
						public boolean verify(String urlHostName, SSLSession session) {
							return true;
						}

					});

			Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.getSocketFactory())
					.register("https", sslConnectionSocketFactory).build();

			PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
			httpBuilder = HttpClientBuilder.create().setConnectionManager(cm);
		}
		return httpBuilder;
	}
	
	public static String post(Map<String,String> reqMap, String method, String appkey, String appSecret)  {
		String result = "";
		String apiUrl = GlobalConfig.pp_url;
		Integer  connTimeOut = Integer.valueOf("10000");
		Map<String, String> headerMap = VerifyUtil.signinMap(method, appkey, appSecret);
		reqMap.putAll(headerMap);
		HttpPost httpPost = new HttpPost(apiUrl);
		RequestConfig config = RequestConfig.custom().setSocketTimeout(connTimeOut)
				               .setConnectTimeout(connTimeOut).build();
		httpPost.setConfig(config);
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			if (reqMap != null) {
				for (Map.Entry<String, String> param : reqMap.entrySet()) {
					String key = param.getKey();
					String value = param.getValue();
					BasicNameValuePair basicPair = new BasicNameValuePair(key, null != value?value : "");
					list.add(basicPair);
				}
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
	            httpPost.setEntity(entity);
			}
			BasicCookieStore cookieStore = new BasicCookieStore();
			httpClient = buildHttpClient(cookieStore, apiUrl).build();
			httpResponse = httpClient.execute(httpPost);
			if(null != httpResponse) {
                HttpEntity resEntity = httpResponse.getEntity();
                if(null != resEntity){  
                    result = EntityUtils.toString(resEntity,"UTF-8");
                }  
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpResponse) {
				try {
					httpResponse.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (null != httpPost) {
				try {
					httpPost.releaseConnection();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (null != httpClient) {
				try {
					httpClient.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
