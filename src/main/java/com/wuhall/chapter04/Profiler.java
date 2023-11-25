package com.wuhall.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal，线程变量，以一个ThreadLocal对象为键，任意对象为值的存储结构
 */
public class Profiler {
    // 第一次get方法调用时会进行初始化，每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
                                                                protected Long initialValue() {
                                                                    return System.currentTimeMillis();
                                                                }
                                                            };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
