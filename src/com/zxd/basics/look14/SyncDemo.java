package com.zxd.basics.look14;

//synchronized关键字
//每个对象有且仅有一个同步锁。这也意味着，同步锁是依赖于对象而存在的
//当我们调用某个对象的synchronized方法时，就获得了该对象的同步锁

//当一个线程访问某对象的synchronized方法或者synchronized代码块时：
//                  1.其他线程对该对象的任意一个synchronized方法或者synchronized代码块的访问将被阻塞。
//                  2.其他线程仍然可以访问该对象的非同步代码块。

public class SyncDemo implements Runnable{
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    //线程休眠
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void hi() throws InterruptedException {
        //同步代码块
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
    public void hello() throws InterruptedException {
        //非同步代码块
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        SyncDemo s = new SyncDemo();

        //t1、t2、t3都是基于SyncDemo对象创建的线程，所以它们共享SyncDemo对象的同步锁
        //所以这三个线程中，当一个线程运行的时候，另外的线程必须等待正在运行的线程释放同步锁之后才能运行
        Thread t1 = new Thread(s,"AA-");
        Thread t2 = new Thread(s,"BB-");
        Thread t3 = new Thread(s,"CC-");

        //t4与t1、t2、t3三个相比，不同之处在于t4是基于Thread对象创建的线程
        //t4自己重写了run()方法，但是t4调用了SyncDemo类中其他被synchronized修饰的代码块
        //所以，t4跟前面的一样会遇到阻塞，只有上一个线程完全执行完毕之后才能抢占资源执行
        //同样的，t4执行时，其他线程会进入阻塞状态
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.hi();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //t5也是是基于Thread对象创建的线程，自己重写了run()方法
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //调用的是SyncDemo类中的普通方法，所以跟前面四个线程相比，它不会遇到阻塞，它可以跟前面的线程抢占资源
                    //前面的线程运行时虽然调用了SyncDemo对象的同步锁，但是t5并没有调用同步锁，所以不会阻塞
                    s.hello();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t4.setName("DD-");
        t5.setName("EE-");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
