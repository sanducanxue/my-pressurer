package com.xusong.mypressurer.net;
import com.xusong.mypressurer.bean.RequestParam;

public interface HttpNet {
    /**
     *
     * @param param
     * @return 请求成功  true  失败 false
     */
    boolean doGet(RequestParam param);

    /**
     *
     * @param param
     * @return 请求成功  true  失败 false
     */
    boolean doPost(RequestParam param);
}
