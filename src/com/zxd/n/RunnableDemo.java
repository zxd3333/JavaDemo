package com.zxd.n;

//多线程的实现方式二：Runnable接口
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            //如果一个类没有继承Thread类，先要获取线程的名字
            //可以使用Thread.currentThread()返回当前正在执行的线程对象的引用
            //然后通过getName()方法获取名字
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread t1 = new Thread(runnableDemo,"AA-");
        Thread t2 = new Thread(runnableDemo,"BB-");
        Thread t3 = new Thread(runnableDemo,"CC-");

        //查看线程的优先级
        System.out.println(t1.getPriority() + "," + t2.getPriority() + "," +t3.getPriority());

        //设置优先级
        //优先级高不一定会先执行
        t3.setPriority(9);

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
