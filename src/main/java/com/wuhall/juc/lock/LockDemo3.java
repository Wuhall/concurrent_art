package com.wuhall.juc.lock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wuhall on 2023/11/26.
 * Content : 多线程锁的实现案例，线程操作资源类
 * 两部手机 观察sendEmail()、sendSMS()先后顺序
 */
public class LockDemo3 {
    public static void main(String[] args) {
        // 使用两部手机，两个this不是同一个对象
        Phone3 phone_a = new Phone3();
        Phone3 phone_b = new Phone3();

        // 启动线程a
        new Thread(() -> {
            phone_a.sendEmail();
        },"a").start();

        // 暂停, 保证a线程先启动
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 启动线程b
        new Thread(() -> {
            phone_b.sendSMS();
        },"b").start();
    }
}

/**
 * 资源类
 */
class Phone3 {

    void sendEmail() {
        synchronized (this) {
            // 线程进来sleep，并没有释放锁
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sendEmail()");
        }
    }

    void sendSMS() {
        synchronized (this) {
            System.out.println("sendSMS()");
        }
    }
}
