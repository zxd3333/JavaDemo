package com.zxd.basics.look05;

import java.util.Calendar;
import java.util.Scanner;

// 日历类的了解
public class CalendarDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        // 获取当天年月日
        int year = calendar.get(Calendar.YEAR);
        // 月份是从 0 开始的，所以要加 1
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("今天是" + year + "年" + month + "月" + day + "日");

        // 在今天基础上将当前年份加10
        calendar.add(Calendar.YEAR,10);
        // 在今天基础上将当前月份减5
        calendar.add(Calendar.MONTH,-5);
        // 输出修改后的日子
        int changeYear = calendar.get(Calendar.YEAR);
        int changeMonth = calendar.get(Calendar.MONTH)+1;
        int changeDay = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("修改后的年月日为:" + changeYear + "年" + changeMonth + "月" + changeDay + "日");
        calendar.set(2020,10,1);

        Scanner sc = new Scanner(System.in);
        // 键盘输入年份
        System.out.print("输入想要设置的年份：");
        int i = sc.nextInt();
        Calendar c = Calendar.getInstance();
        // 这里设置时间为 输入年份的4月1日
        c.set(i,3,1);
        // 在设置的时间上减去一天，即3月最后一天
        c.add(Calendar.DATE,-1);
        // 获取设置的年月日
        int newYear = c.get(Calendar.YEAR);
        int newMonth = c.get(Calendar.MONTH)+1;
        int newDay = c.get(Calendar.DAY_OF_MONTH);
        // 获取设置的月份总天数
        int num = c.get(Calendar.DATE);
        System.out.println("设置后的日期是：" + newYear + "年" + newMonth + "月" + newDay + "日" + "," + "当月有" + num + "天");
    }
}
