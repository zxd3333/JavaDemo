package com.zxd.n;

//说到线程，就不得不首先说一下进程，因为线程是依赖于进程的
//进程：是正在运行的程序。
//     是系统进行资源分配和调度的独立单位
//           每个进程都有它自己的内存空间和系统资源
//线程：进程中的单个顺序控制流，是一条执行路径
//           单线程：一个进程如果只有一条执行路径，那么它就是单线程程序
//           多线程：一个进程如果有多条执行路径，那么它就是多线程程序
//了解：线程在执行过程中必须得到CPU资源，由Thread模拟一个虚拟的CPU
//           我们把CPU执行的代码和操作过程中的数据，传递给Thread类
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
