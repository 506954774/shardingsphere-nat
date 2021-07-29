package com.jisen.rws.utils;

/**
 * @author jisen
 * @date 2021/7/28 16:03
 */
public class NanoTimeUtils {
    public synchronized static Long getNanoTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long nanoTime = System.nanoTime();
        System.out.println("获取纳秒时间戳："+(currentTimeMillis * 1000000L + nanoTime/100 % 1000000L));
        return currentTimeMillis * 1000000L + nanoTime/100 % 1000000L;
    }
}
