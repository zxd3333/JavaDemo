package com.zxd.basics.look13;

import java.util.Random;

// 龟兔赛跑
// 多线程
public class RaceDemo implements Runnable{

    private String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++){
            // 若有了胜利者，就跳出循环
            if (winner != null){
                System.out.println(winner + "赢了");
                break;
            }else {
                // i到100就把当前线程当做胜利者，然后跳出循环
                if (i == 100) {
                    winner = Thread.currentThread().getName();
                    break;
                } else {
                    // 模拟兔子在终点前睡觉
                    if (Thread.currentThread().getName().equals("兔兔") && i == 90){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 记录跑步过程
                    System.out.println(Thread.currentThread().getName() + "跑到了第" + i + "步");
                }
            }
        }
    }

    public static void main(String[] args) {
        RaceDemo demo = new RaceDemo();

        new Thread(demo,"兔兔").start();
        new Thread(demo,"龟龟").start();

    }
}
