package com.zxd.basics.look05;

import java.text.SimpleDateFormat;
import java.util.Date;

// Date和SimpleDateFormat的初步了解
public class DateDemo {

    public static void main(String[] args) {
        // 定义并输出当前时间
        Date date = new Date();
        System.out.println(date);

        // 介于上面直接输出date我们无法很迅速的看出当前时间
        // 于是使用SimpleDateFormat定义时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
