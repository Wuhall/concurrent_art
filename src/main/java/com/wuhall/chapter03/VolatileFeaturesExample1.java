package com.wuhall.chapter03;

class VolatileFeaturesExample1 {
    // 64bit
    long vl = 0L;

    /**
     * 对单个的普通变量的写使用一个锁同步
     * @param l
     */
    public synchronized void set(long l) {
        vl = l;
    }

    /**
     * 普通方法的调用
     */
    public void getAndIncrement() {
        long temp = get();
        temp += 1L;
        set(temp);
    }

    /**
     * 对普通变量的读使用一个同步方法
     * @return
     */
    public synchronized long get() {
        return vl;
    }
}
