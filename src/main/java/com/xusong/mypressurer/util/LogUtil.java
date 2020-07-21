package com.xusong.mypressurer.util;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LogUtil {
    //总共执行的次数
    public static AtomicInteger totalTimes = new AtomicInteger(0);
    //成功执行的次数
    public static   AtomicInteger successTimes = new AtomicInteger(0);
    //失败的次数
    public static   AtomicInteger errorTimes = new AtomicInteger(0);

    public static List<Long> runTimeList = new CopyOnWriteArrayList<>();

    //清除记录次数
    public static void cleanTimes(){
        totalTimes = new AtomicInteger(0);
        successTimes = new AtomicInteger(0);
        errorTimes = new AtomicInteger(0);
        runTimeList.clear();
    }
    public static void addTotalTimes(){
        totalTimes.incrementAndGet();
    }
    public static void addSuccessTimes(){
        successTimes.incrementAndGet();
    }
    public static void addErrorTimes(){
        errorTimes.incrementAndGet();
    }

    public static void addrunTimeList(long time){
        runTimeList.add(time);
    }
    //打印性能参数
    public static void print(){
        if (!check()){
            return;
        }
        double success = (double) successTimes.get();
        double total = (double) totalTimes.get();
        //成功比例
        int successRate = (int) ((success / total) *100);
        int size = runTimeList.size();
        List<Long> sortList = runTimeList.stream().sorted().collect(Collectors.toList());
        int position95 = (int) (size * 0.95);
        //排名第百分之九十五的请求 耗时
         Long time95 = sortList.get(position95);
        long sum = runTimeList.stream().mapToLong(Long::longValue).sum();
        //平均时间
        long averageTime = sum / size;
        System.out.println("成功比例：" + successRate + "%  平均耗时：" + averageTime + "  耗时排名95%的请求耗时：" + time95);
        //System.out.println("totalTimes：" + totalTimes + "  successTimes：" + successTimes + "  errorTimes：" + errorTimes +
         //       " 平均耗时: " + averageTime);
        //清理
        cleanTimes();
    }
    private static boolean check(){
        return totalTimes.get() != 0 && successTimes.get() != 0 && runTimeList.size() != 0;
    }
}
