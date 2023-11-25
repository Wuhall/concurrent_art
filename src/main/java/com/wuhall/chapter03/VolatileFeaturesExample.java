package com.wuhall.chapter03;

class VolatileFeaturesExample {
    // 使用volatile声明64位的long类型变量
    volatile long vl = 0L;

    public void set(long l) {
        // 单个volatile变量的写
        vl = l;
    }

    public void getAndIncrement() {
        // 多个volatile变量的读写
        vl++;
    }

    public long get() {
        // 单个volatile变量的读
        return vl;
    }
}
