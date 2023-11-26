package com.wuhall.juc.fair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Wuhall on 2023/11/26.
 * Content : 公平锁与非公平锁
 */
public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {for (int i = 0; i < 55; i ++) ticket.sale();}, "a").start();
        new Thread(() -> {for (int i = 0; i < 55; i ++) ticket.sale();}, "b").start();
        new Thread(() -> {for (int i = 0; i < 55; i ++) ticket.sale();}, "c").start();
    }
}

class Ticket {
    private int number = 50;
    // 默认是非公平锁
    ReentrantLock lock  = new ReentrantLock();
    // ReentrantLock lock  = new ReentrantLock(true);

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "  sale:" + number-- + "  left:" + number);
            }
        } finally {
            lock.unlock();
        }
    }
}