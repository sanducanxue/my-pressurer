package com.xusong.mypressurer;

import com.xusong.mypressurer.bean.RequestParam;
import com.xusong.mypressurer.pool.APoolManager;
import com.xusong.mypressurer.test_case.LeafCase;

/**
 * 压力测试框架启动类
 */
public class PressurerMain {
    //线程总数
    public static int threadNums = 100;
    //打印间隔时间
    public static long sleepTime = 1000;
    //请求超时时间
    public static int timeOut = 2000;

    public static void main(String[] args) {
        APoolManager aPoolManager = new APoolManager(threadNums);
        /*ContainerCase containerCase = new ContainerCase(10,100);
        containerCase.addCase(new LeafCase("https://www.baidu.com/",10,100, RequestParam.GET));
        containerCase.addCase(new LeafCase("http://news.baidu.com/",10,100, RequestParam.GET));
        containerCase.addCase(new LeafCase("https://zhidao.baidu.com/",10,100, RequestParam.GET));
        aPoolManager.execute(containerCase);*/

        aPoolManager.execute(new LeafCase("https://www.baidu.com/",10,100, RequestParam.GET));
    }
}
