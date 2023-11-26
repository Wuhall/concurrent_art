package com.wuhall.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wuhall on 2023/11/26.
 * Content :
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        final Object objectA = new Object();
        final Object objectB = new Object();
        new Thread(()-> {
            synchronized (objectA) {
                System.out.println(Thread.currentThread().getName());
                // 暂停
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectB) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }, "a").start();

        new Thread(()-> {
            synchronized (objectB) {
                System.out.println(Thread.currentThread().getName());
                // 暂停
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectA) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }, "b").start();
    }
}
