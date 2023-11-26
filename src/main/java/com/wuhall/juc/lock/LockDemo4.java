package com.wuhall.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wuhall on 2023/11/26.
 * Content : 多线程锁的实现案例，线程操作资源类
 * 两个静态同步方法，观察sendEmail()、sendSMS()先后顺序
 *
 */
public class LockDemo4 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();

        // 启动线程a
        new Thread(() -> {
            phone.sendEmail();
        },"a").start();

        // 暂停, 保证a线程先启动
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 启动线程b
        new Thread(() -> {
            phone.sendSMS();
        },"b").start();
    }
}

/**
 * 资源类
 */
class Phone4 {

    static synchronized void sendEmail() {
        // 线程进来sleep，并没有释放锁
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail()");
    }

    static synchronized void sendSMS() {
        System.out.println("sendSMS()");
    }
}
