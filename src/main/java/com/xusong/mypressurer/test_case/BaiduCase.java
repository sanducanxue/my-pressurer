package com.xusong.mypressurer.test_case;


import com.xusong.mypressurer.bean.RequestParam;

public class BaiduCase extends LeafCase{
    @Override
    public void setRequestParam() {
        requestParam = new RequestParam("http://47.98.113.122:8090/hello",2000,100000,RequestParam.GET);
    }
}
