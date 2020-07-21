package com.xusong.mypressurer;

import com.xusong.mypressurer.pool.APoolManager;
import com.xusong.mypressurer.test_case.BaiduCase;

/**
 * 压力测试框架启动类
 */
public class PressurerMain {
    public static void main(String[] args) {
        APoolManager aPoolManager = new APoolManager(10);
        BaiduCase baiduCase = new BaiduCase();
        aPoolManager.execute(baiduCase);
    }
}
