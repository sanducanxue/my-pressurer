package com.xusong.mypressurer.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class DefaultPoolManager implements PoolManager{
    //线程池,默认初始化500个线程
    ExecutorService pool = Executors.newFixedThreadPool(500);
    @Override
    public void initPool(int threadNums) {
         pool = Executors.newFixedThreadPool(threadNums);
    }
}
