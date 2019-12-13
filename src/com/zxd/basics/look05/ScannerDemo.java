package com.zxd.basics.look05;

import java.util.Scanner;

// Scanner类的初步使用
public class ScannerDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* nextInt()方法会在尾部添加换行符
           Windows的换行符是\r\n
           nextLine()方法会把换行符录入导致代码无效
           所以这里首先录入了字符串
         */
        System.out.print("从键盘上输入一个字符串：");
        String str = sc.nextLine();
        System.out.println("你输入的字符串是" + str);

        System.out.print("从键盘上输入一个整数：");
        int num = sc.nextInt();
        System.out.println("你输入的数字是" + num);
    }
}
