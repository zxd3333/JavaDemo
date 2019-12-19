package com.zxd.basics.look13;

import com.zxd.basics.look09.ThrowsDemo;

// 线程
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public static void main(String[] args) {
        // 创建线程对象
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();

        // 设置线程名称
        t1.setName("AA-");
        t2.setName("BB-");

        // 直接使用run()方法相当于调用了普通方法，并没有启动线程
        // t1.run();
        // t2.run();

        // 调用start()方法，线程开始执行，由Java虚拟机调用此线程的run()方法
        t1.start();
        t2.start();

        // 主线程和子线程们并行交替执行
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
