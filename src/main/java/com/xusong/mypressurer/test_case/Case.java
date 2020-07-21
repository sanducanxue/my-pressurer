package com.xusong.mypressurer.test_case;

import com.xusong.mypressurer.bean.RequestParam;
import com.xusong.mypressurer.net.HttpNet;
import com.xusong.mypressurer.net.HttpNetImp;


/**
 * 测试用例模板
 * 用组合模式组合成树状结构，
 * 包含容器节点ContainerCase和
 * 叶子节点LeafCase 容器节点可以继续向下组合叶子节点
 */
public abstract class Case implements Runnable {


    //请求参数
    RequestParam requestParam;

    static HttpNet httpNet = new HttpNetImp();

    public RequestParam getRequestParam() {
        return requestParam;
    }
    /**
     * 设置请求参数
     */
    public abstract void setRequestParam();
}
