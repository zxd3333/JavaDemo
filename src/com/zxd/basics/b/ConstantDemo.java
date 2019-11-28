package com.zxd.basics.b;

//常量
public class ConstantDemo {

    //普通常量
    public final int A_NUM = 100;
    //静态常量
    public static final int B_NUM = 200;

    //程序的入口：main方法
    public static void main(String[] args) {

        //方法中访问外部的普通常量
        ConstantDemo constant = new ConstantDemo();
        System.out.println(constant.A_NUM);

        //方法中访问静态常量
        System.out.println(B_NUM);

        //方法中访问方法中的普通常量
        final int C_NUM = 300;
        System.out.println(C_NUM);
    }
}
