package com.xusong.mypressurer.pool;


import com.xusong.mypressurer.test_case.Case;

/**
 * 线程池管理类
 */
public interface  PoolManager {
    /**
     * 初始化线程池
     * @param threadNums 线程数量
     */
    void initPool(int threadNums);

    /**
     *
     * @param testCase 传入测试用例
     */
    void execute(Case testCase);
}
