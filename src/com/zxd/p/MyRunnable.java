package com.zxd.p;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("多线程启动了！");
    }
}
