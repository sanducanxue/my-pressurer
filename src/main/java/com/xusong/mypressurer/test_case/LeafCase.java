package com.xusong.mypressurer.test_case;

import com.xusong.mypressurer.bean.RequestParam;
import com.xusong.mypressurer.util.LogUtil;

/**
 * 叶子节点测试用例
 */
public class LeafCase extends Case{

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
        //TODO post请求方式待开发
        /*if (requestParam.getMethodType().equals(RequestParam.POST)){
            long start = System.currentTimeMillis();
            boolean result = httpNet.doPost(requestParam);
            long end = System.currentTimeMillis();
        }*/
    }

    public LeafCase(String uri, int concurrentNums, int totalNums, String methodType) {
         requestParam = new RequestParam(uri, concurrentNums, totalNums, methodType);
    }

    /**
     * 需要添加请求参数的时候直接传入请求对象
     * @param requestParam
     */
    public LeafCase(RequestParam requestParam) {
        super.requestParam = requestParam;
    }
}
