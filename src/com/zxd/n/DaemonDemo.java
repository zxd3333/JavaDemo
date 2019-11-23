package com.zxd.n;

//守护线程
//守护线程是指在程序运行的时候在后台提供一种通用服务的线程，这种线程并不属于程序中不可或缺的部分
//比如垃圾回收线程就是一个守护线程。
//当所有的非守护线程结束时，程序也就终止了，同时会杀死进程中的所有守护线程。
//也就是说，当程序中的线程都是守护线程，程序就会终止；只要任何非守护线程还在运行，程序就不会终止。
public class DaemonDemo extends Thread{

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

        //正常情况下，主线程开始，然后子线程开始，子线程休眠
        //然后主线程休眠，主线程运行完毕想结束了，但是子线程还没有完
        //所以在输出main结束之后，子线程还会继续输出内容
        System.out.println(Thread.currentThread().getName() + "开始");

        DaemonDemo t1 = new DaemonDemo();
        DaemonDemo t2 = new DaemonDemo();

        //但是当把子线程设置成守护线程之后，主线程已结束，程序中就剩下了守护线程，所以程序会直接结束
        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "结束");
    }
}
