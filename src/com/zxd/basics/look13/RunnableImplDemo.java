package com.zxd.basics.look13;

// 实现Runnable接口
public class RunnableImplDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public static void main(String[] args) {

        // 创建Runnable接口的实现类对象
        RunnableImplDemo runnableImplDemo = new RunnableImplDemo();

        // 创建线程对象，通过线程对象开启线程
        Thread t1 = new Thread(runnableImplDemo,"AA-");
        Thread t2 = new Thread(runnableImplDemo,"BB-");
        Thread t3 = new Thread(runnableImplDemo,"CC-");

        // 启动线程
        t1.start();
        t3.start();
        t2.start();

    }
}
