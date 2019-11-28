package com.zxd.basics.n;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//多线程买票
//直接写出之后发现有些票卖出去不止一次，显然不合实际
//也就是说我们的多线程出现了数据安全问题
//为了解决这些问题，可以把他们共享的数据，也就是tickets，加上同步锁
public class BuyTicketsByThreadDemo extends Thread {

    private int tickets = 100;
/*
    @Override
    public void run() {
            //死循环可以一直卖票
            while (true) {
                synchronized (this) {
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + tickets);
                        tickets--;
                        //卖一张票休息一下
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        break;
                    }
                }
            }
    }
*/

    //第二种方法，使用Lock
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + tickets);
                    tickets--;
                    //卖一张票休息一下
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        BuyTicketsByThreadDemo demo = new BuyTicketsByThreadDemo();
        Thread t1 = new Thread(demo,"窗口1");
        Thread t2 = new Thread(demo,"窗口2");
        Thread t3 = new Thread(demo,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
