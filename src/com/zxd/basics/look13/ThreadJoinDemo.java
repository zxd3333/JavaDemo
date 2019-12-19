package com.zxd.basics.look13;

// 线程的join()方法 -> 线程插队
public class ThreadJoinDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i < 50; i++){
            System.out.println("我是第" + i + "个插队怪");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 启动线程
        ThreadJoinDemo joinDemo = new ThreadJoinDemo();
        Thread t1 = new Thread(joinDemo);
        t1.start();

        for (int i = 1; i < 100; i++){
            System.out.println("我是第" + i +"个有良心的好人");
            if (i == 98){
                // 开始插队了
                t1.join();
            }
        }
    }
}
