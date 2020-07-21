package com.xusong.mypressurer.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求参数
 */
public class RequestParam {
    public static final String GET = "GET";
    public static final String POST = "POST";
    //url
    private String uri;
    //并发数 默认50
    private int concurrentNums = 1;
    //循环总次数 默认1000
    private int totalNums = 1000;
    //http请求类型 默认get
    private String methodType = GET;
    //参数列表
    private Map<String,String> paramMap = new HashMap<>();

    public RequestParam(String uri) {
        this.uri = uri;
    }

    public RequestParam(String uri, int concurrentNums, int totalNums, String methodType) {
        this.uri = uri;
        this.concurrentNums = concurrentNums;
        this.totalNums = totalNums;
        this.methodType = methodType;
    }

    public void setParam(String key, String value){
        paramMap.put(key,value);
    }
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public int getConcurrentNums() {
        return concurrentNums;
    }

    public void setConcurrentNums(int concurrentNums) {
        this.concurrentNums = concurrentNums;
    }

    public int getTotalNums() {
        return totalNums;
    }

    public void setTotalNums(int totalNums) {
        this.totalNums = totalNums;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }
}
