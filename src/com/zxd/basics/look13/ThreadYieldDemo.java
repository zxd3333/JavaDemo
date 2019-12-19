package com.zxd.basics.look13;

// 线程的yield()方法 -> 线程礼让
// 礼让不一定会成功，成功就换另一个线程开始执行
public class ThreadYieldDemo {

    public static void main(String[] args) {
        YieldImpl y1 = new YieldImpl();
        YieldImpl y2 = new YieldImpl();
        new Thread(y1).start();
        new Thread(y2).start();
    }
}

class YieldImpl implements Runnable{

    @Override
    public void run() {
        System.out.println("线程开始执行");
        Thread.yield(); // 线程礼让
        System.out.println("线程停止执行");
    }
}
