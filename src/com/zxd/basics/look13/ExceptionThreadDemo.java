package com.zxd.basics.look13;

// 多个线程同时操作同一个对象
// 会引发安全问题
public class ExceptionThreadDemo implements Runnable{

    // 模拟买票，探究问题
    private int tickets = 10;
    @Override
    public void run() {

        while (true){

            // 如果没票了就跳出循环
            if (tickets < 0){
                break;
            }

            System.out.println(Thread.currentThread().getName() + ":" + tickets);
            // 模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets--;
        }
    }

    public static void main(String[] args) {
        ExceptionThreadDemo demo = new ExceptionThreadDemo();

        new Thread(demo,"小白").start();
        new Thread(demo,"小黑").start();
        new Thread(demo,"小花").start();
    }
}
