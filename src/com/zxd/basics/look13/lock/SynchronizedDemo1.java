package com.zxd.basics.look13.lock;

import java.util.concurrent.locks.ReentrantLock;

// 买票中使用synchronized
public class SynchronizedDemo1 {

    public static void main(String[] args) {

        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"小白").start();
        new Thread(buyTicket,"小黑").start();
        new Thread(buyTicket,"小花").start();
    }
}

class BuyTicket implements Runnable{

    private int tickets = 10;

    private boolean flag = true;
//    @Override
//    public void run() {
//        // 买票
//        while (flag) {
//            // 给调用的对象（buyTicket）加上了锁，所有线程都可以进入到循环里面，但是只有第一个进来的线程可以执行
//            // 执行完毕后，三个线程谁能继续进入谁就能执行，一次只能执行一个线程
//            synchronized (this) {
//                if (tickets <= 0) {
//                    flag = false;
//                    break;
//                } else {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "买了第" + tickets-- + "张票");
//                }
//            }
//        }
//    }

    // 使用Lock实现同步
    // 定义锁
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        // 买票
        while (flag) {
            try {
                // 下面会对票进行修改，所以这里开启锁
                // 需要显示的声明来开启锁
                lock.lock();
                if (tickets <= 0) {
                    flag = false;
                    break;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买了第" + tickets-- + "张票");
                }
            }finally {
                // 为了防止出现异常没有关闭锁，使用了try...finally语句
                // 需要显示的声明关闭锁
                lock.unlock();
            }
        }
    }
}