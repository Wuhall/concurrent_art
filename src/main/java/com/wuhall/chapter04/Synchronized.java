package com.wuhall.chapter04;

/**
 * 6-10
 */
public class Synchronized {
    public static void main(String[] args) {
        // ��Synchronized Class对象进行加锁
        synchronized (Synchronized.class) {

        }
        // 静态同步方法，对synchronized class对象进行加锁
        m();
    }

    public static synchronized void m() {
    }
}
