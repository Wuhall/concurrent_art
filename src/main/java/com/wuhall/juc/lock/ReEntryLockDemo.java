package com.wuhall.juc.lock;

/**
 * Created by Wuhall on 2023/11/26.
 * Content : synchronized默认是可重入锁
 */
public class ReEntryLockDemo {
    public static void main(String[] args) {
        final Object o = new Object();
        new Thread(() -> {
           synchronized (o) {
               System.out.println("invoke1");
               synchronized (o) {
                   System.out.println("invoke2");
               }
           }
        }).start();
    }
}
