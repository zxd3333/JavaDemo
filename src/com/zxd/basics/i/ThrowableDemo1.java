package com.zxd.basics.i;

import java.util.Scanner;

//异常
public class ThrowableDemo1 {
    public static void main(String[] args) {
        System.out.println("除法演示Exception");
        Scanner sc = new Scanner(System.in);
        //try语句写可能发生异常的代码
        //如果某条语句出现异常，那么会抛出相应的异常对象
        //catch语句根据异常对象的类型进行捕获处理
        //处理之后会在控制台显示异常信息的详情
        //同时会跳过try语句中发生异常的代码之后的语句
        try{
            System.out.println("输入第一个数字");
            int num1 = sc.nextInt();
            System.out.println("输入第二个数字");
            int num2 = sc.nextInt();
            int result = num1 / num2;
            System.out.println("结果是：" +result);
        }catch (Exception e){
            System.out.println(e.getMessage()); //返回异常发生时的描述信息
            System.out.println(e.toString()); //返回异常异常类型和描述信息
            e.printStackTrace(); //在控制台上打印异常对象封装的异常信息
        }
        System.out.println("这是try...catch语句之后的内容");
    }
}
