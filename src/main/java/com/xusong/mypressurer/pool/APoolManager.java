package com.xusong.mypressurer.pool;
import com.xusong.mypressurer.bean.RequestParam;
import com.xusong.mypressurer.test_case.Case;
import com.xusong.mypressurer.util.LogUtil;
/**
 * A型  并发数与线程数不绑定
 */
public class APoolManager extends DefaultPoolManager{

    @Override
    public void execute(Case testCase) {

        int currenttimes = 0;
        RequestParam requestParam = testCase.getRequestParam();
        //并发数
        int concurrentNums = requestParam.getConcurrentNums();
        //执行总次数
        int totalNums = requestParam.getTotalNums();

        while (true){
            //模拟并发次数
            for (int i = 0; i < concurrentNums; i++) {
                pool.execute(testCase);
                //这里是单线程
                currenttimes ++;
            }
            try {
                //打印日志
                Thread.sleep(3000);
                LogUtil.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public APoolManager(int threadNums) {
        initPool(threadNums);
    }
    public APoolManager() {
    }
}
