package com.zxd.basics.n;

//线程控制
//sleep()只能让当前线程睡眠
//join()是让当前线程执行完之后，下一个线程才能继续执行
public class ThreadWaitDemo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            if ( i == 8){
                try {
                    //线程休眠
                    //调用start()方法的线程进入这个判断条件之后会休眠1000ms
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadWaitDemo t1 = new ThreadWaitDemo();
        ThreadWaitDemo t2 = new ThreadWaitDemo();
        ThreadWaitDemo t3 = new ThreadWaitDemo();

        t1.start();
        //t1执行完之后，后面的才可以执行
        t1.join();
        t2.start();
        t3.start();

    }
}