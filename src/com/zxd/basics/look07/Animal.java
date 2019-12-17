package com.zxd.basics.look07;

// 抽象类
public abstract class Animal {

    private String name;

    public Animal(){

    }

    // 静态方法
    public static void run(){
        System.out.println("动物可以跑");
    }

    // 抽象方法
    public abstract void eat();
}
