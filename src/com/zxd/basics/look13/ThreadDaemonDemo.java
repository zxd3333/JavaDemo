package com.zxd.basics.look13;

// 守护线程
// 线程默认都是非守护线程
// 当所有的非守护线程结束时，程序也就终止了，同时会杀死进程中的所有守护线程。
public class ThreadDaemonDemo implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) throws InterruptedException {

        // 正常情况下的执行顺序
        /*
           main开始
           A开始
           B开始
           main结束
           A结束
           B结束
         */
        System.out.println(Thread.currentThread().getName() + "开始");

        ThreadDaemonDemo daemonDemo = new ThreadDaemonDemo();
        Thread t1 = new Thread(daemonDemo,"A");
        Thread t2 = new Thread(daemonDemo,"B");

        // 当把t1 t2设置为守护线程时，主线程只休眠一秒就结束
        // 剩下的全是守护线程，程序便会直接结束，控制台会输出
        /*
           main开始
           A开始
           B开始
           main结束
         */
        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "结束");
    }
}