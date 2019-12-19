package com.zxd.basics.look13.lock;

// 死锁
public class SynchronizedDemo3 {

    public static void main(String[] args) {

        Boy b1 = new Boy(0,"小黑");
        Boy b2 = new Boy(1,"小白");
        new Thread(b1).start();
        new Thread(b2).start();
    }
}

class Car{

}

class Book{

}

class Boy implements Runnable{
    // 用static保证需要的车和书都只有一个
    private static Car car = new Car();
    private static Book book = new Book();

    private int choice;
    private String name;

    public Boy(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            want();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 两者都想拿到对方的资源，但是又没有放开自己的锁，导致两个人都无法访问，程序进入死锁状态
    public void want() throws InterruptedException {
        if (choice == 0){
            synchronized (car){
                System.out.println(this.name + "获得car的锁");
                Thread.sleep(1000);

//                // 没有释放car的锁就想要获得book的锁
//                synchronized (book){
//                    System.out.println(this.name + "获得book的锁");
//                }
            }
            // 解决办法，想要获得别的锁就首先要释放自己的锁，在锁的外部定义另一个锁
            synchronized (book){
                System.out.println(this.name + "获得book的锁");
            }
        } else {
            synchronized (book){
                System.out.println(this.name + "获得book的锁");
                Thread.sleep(1000);

//                // 没有释放book的锁就想要获得car的锁
//                synchronized (car){
//                    System.out.println(this.name + "获得car的锁");
//                }
            }
            synchronized (car){
                System.out.println(this.name + "获得car的锁");
            }
        }

    }
}
