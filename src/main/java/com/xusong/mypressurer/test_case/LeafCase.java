package com.xusong.mypressurer.test_case;

import com.xusong.mypressurer.bean.RequestParam;
import com.xusong.mypressurer.util.LogUtil;

/**
 * 叶子节点测试用例
 */
public abstract class LeafCase extends Case{

    @Override
    public void run() {
        if (requestParam.getMethodType().equals(RequestParam.GET)){
            long start = System.currentTimeMillis();
            boolean result = httpNet.doGet(requestParam);
            long end = System.currentTimeMillis();
            long time = end -start;
            LogUtil.addTotalTimes();
            if (result){
                //请求成
                LogUtil.addSuccessTimes();
                LogUtil.addrunTimeList(time);

            }else {
                //请求失败
                LogUtil.addErrorTimes();
            }
        }
        if (requestParam.getMethodType().equals(RequestParam.POST)){
            long start = System.currentTimeMillis();
            boolean result = httpNet.doPost(requestParam);
            long end = System.currentTimeMillis();
        }
    }

}
