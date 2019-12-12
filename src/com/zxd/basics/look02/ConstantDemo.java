package com.zxd.basics.look02;

// 常量
// 普通常量：被final修饰的常量，可以定义再类中和方法中
// 静态常量：被static final修饰的常量,只能在类中方法外定义
public class ConstantDemo {

    // 类中方法外的普通常量
    public final int A_NUM = 100;
    // 类中方法外的静态常量
    public static final int B_NUM = 200;

    // 程序的入口：main方法
    public static void main(String[] args) {
        // 调用method()方法
        method();
    }

    public static void method(){
        // 方法中的普通常量
        final int C_NUM = 300;

        // 方法中访问外部的普通常量
        ConstantDemo constant = new ConstantDemo();
        System.out.println(constant.A_NUM);

        // 方法中访问外部的静态常量
        System.out.println(B_NUM);

        // 方法中访问方法中的普通常量
        System.out.println(C_NUM);
    }
}
