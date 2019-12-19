package com.zxd.basics.look13;

import java.text.SimpleDateFormat;
import java.util.Date;

// 线程的sleep()方法 -> 线程休眠
public class ThreadSleepDemo {

    public static void main(String[] args) {
        // 获取当前时间
        Date date = new Date(System.currentTimeMillis());

        while (true) {
            try {
                // 休眠一秒
                Thread.sleep(1000);
                // 打印当前时间
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                //更新时间
                date = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
