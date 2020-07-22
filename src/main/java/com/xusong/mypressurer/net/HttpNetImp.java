package com.xusong.mypressurer.net;

import com.xusong.mypressurer.PressurerMain;
import com.xusong.mypressurer.bean.RequestParam;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

/**
 * http 基础通讯类
 */
@Component
public class HttpNetImp implements HttpNet {
    @Override
    public boolean doGet(RequestParam param) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 定义请求的参数
        //URI uri = new URIBuilder("http://www.baidu.com/s").setParameter("wd", "java").build();
        //response 对象
        CloseableHttpResponse response = null;
        try {
            Map<String, String> paramMap = param.getParamMap();
            URI uri;
            if (paramMap.size() == 0) {
                uri = new URIBuilder(param.getUri()).build();
            } else {
                URIBuilder uriBuilder = setParams(param, paramMap);
                uri = uriBuilder.build();
            }
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            //设置超时时间为2秒
            RequestConfig requestConfig =  RequestConfig.custom().setSocketTimeout(PressurerMain.timeOut).setConnectTimeout(PressurerMain.timeOut).build();
            httpGet.setConfig(requestConfig);

            // 执行http get请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                return true;
            }
        } catch (IOException | URISyntaxException e) {
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
            }
        }

        return false;
    }

    @Override
    public boolean doPost(RequestParam param) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(param.getUri());
        // 设置2个post参数，一个是scope、一个是q
     /*   List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("scope", "project"));
        parameters.add(new BasicNameValuePair("q", "java"));*/
        // 构造一个form表单式的实体
        try {
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(new ArrayList<>());
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(formEntity);
            //伪装浏览器
            httpPost.setHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");

            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 设置参数
     *
     * @param param
     * @param paramMap
     * @return
     * @throws URISyntaxException
     */
    private URIBuilder setParams(RequestParam param, Map<String, String> paramMap) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(param.getUri());
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            uriBuilder.addParameter(key, value);
        }
        return uriBuilder;
    }
}
