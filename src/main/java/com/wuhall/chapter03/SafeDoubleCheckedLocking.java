package com.wuhall.chapter03;

public class SafeDoubleCheckedLocking {
    // 注意这里的volatile 禁止了line:11 new Instance() 初始化与引用赋值这两步的重排序
    private volatile static Instance instance;

    public static Instance getInstance() {
        // 这一步的校验是为了减少同步代码块的开销
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null)
                    instance = new Instance();
            }
        }
        return instance;
    }

    static class Instance {
    }
}
