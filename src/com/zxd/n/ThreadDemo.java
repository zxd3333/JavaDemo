package com.zxd.n;

//多线程的实现方式一：Thread
public class ThreadDemo extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println(getName() + ":" + i);
        }
    }

    public static void main(String[] args) {

        System.out.println("线程最大优先级："+Thread.MAX_PRIORITY); //10
        System.out.println("线程最小优先级:"+Thread.MIN_PRIORITY);  //1
        System.out.println("线程默认优先级："+Thread.NORM_PRIORITY);//5

        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();

        //设置线程名称
        t1.setName("AA-");
        t2.setName("BB-");

        //直接使用run()方法并没有启动线程
        //t1.run();
        //t2.run();

        //调用start()方法，线程开始执行，Java虚拟机调用此线程的run()方法
        t1.start();
        t2.start();

        //两者区别：我们重写了run()方法，直接调用时，相当于普通方法
        //start()方法是由JVM调用线程的run()方法
    }
}
