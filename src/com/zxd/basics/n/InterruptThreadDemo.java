package com.zxd.basics.n;

//中断线程
public class InterruptThreadDemo extends Thread{

    @Override
    public void run() {
        int i = 0;

        //通过死循环判断线程是否中断
        while (! isInterrupted()){
            i++;
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptThreadDemo t1 = new InterruptThreadDemo();

        //返回状态后，会重置当前线程的中断状态
        System.out.println("判断当前线程是否处于中断状态：" + t1.interrupted());
        System.out.println("判断主线程是否处于中断状态：" + Thread.interrupted());

        t1.start();
        Thread.sleep(1);  //休眠10ms
        //interrupt()不会去真正意义上的打断一个正在运行的线程，而是修改这个线程的中断状态码
        //如果遇到阻塞状态的线程，则会抛出异常
        //中断t线程，此方法只是发出了中断请求，至于t线程能否立刻响应，要看具体代码
        t1.interrupt();
        //调用interrupt()方法后，会改变该线程的中断状态码
        //调用isInterrupted()会返回该线程的中断状态码
        System.out.println("判断当前线程是否处于中断状态：" + t1.isInterrupted());
        t1.join();  //等待t线程结束后再执行main线程


    }
}
