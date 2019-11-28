package com.zxd.basics.g;

//定义一个接口
public interface HelloInterface {
    //抽象方法
    public abstract void show();
    //默认方法
    //Java 8 中，接口可以有自己的默认方法(默认使用public修饰)
    //默认方法可以不被重写，也可以重写，重写时去掉default关键字
    default void show1(){
        System.out.println("接口默认方法");
    }
    //静态方法
    static void show2(){
        System.out.println("接口静态方法");
    }
}
