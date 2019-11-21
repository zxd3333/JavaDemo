package com.zxd.n;

//synchronized关键字
//为了解决共享资源竞争的问题
//共享资源一般以对象的形式存在
//控制共享资源的访问，首先把它包装成一个对象
//然后把所有要访问的这个共享资源的方法标记为synchronized
//如果某个任务处于一个对标记为synchronized的方法的调用中，那么在这个线程从该方法返回之前，其他所有要调用类中任何标记为synchronized方法的线程都会被阻塞
//所有对象都自动含有单一的锁（也称为监视器）。当在对象上调用其任意synchronized方法的时候，对象被加锁，这时该对象上的其他synchronized方法只有等到前一个方法调用完毕并释放了锁之后才能被调用。

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

    //同步代码块
    public void hi() throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
    //非同步代码块
    public void hello() throws InterruptedException {
        for (int i = 0; i < 5; i++){
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        SyncDemo s = new SyncDemo();

        //t1、t2、t3都是基于SyncDemo对象创建的线程，所以它们共享SyncDemo对象的同步锁
        //所以，当一个线程运行的时候，另外的线程必须等待正在运行的线程释放同步锁之后才能运行
        Thread t1 = new Thread(s,"AA-");
        Thread t2 = new Thread(s,"BB-");
        Thread t3 = new Thread(s,"CC-");

        t1.start();
        t2.start();
        t3.start();

        //t4与t1、t2、t3三个相比，不同之处在于t4是基于Thread对象创建的线程
        //t4自己重写了run()方法，但是t4调用了本类中的其他synchronized代码块
        //所以，t4跟前面的一样会遇到阻塞
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
        t4.setName("DD-");

        //t5自己重写了run()方法
        //调用的也是本类中的普通方法，所以不会遇到阻塞
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.hello();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t5.setName("EE-");

        t4.start();
        t5.start();
    }
}
