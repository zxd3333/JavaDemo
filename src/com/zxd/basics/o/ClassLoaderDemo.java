package com.zxd.basics.o;

//类加载器
public class ClassLoaderDemo {

    public static void main(String[] args) {
        //获取类加载器对象
        //返回用于委派的系统类加载器c
        ClassLoader c = ClassLoader.getSystemClassLoader();
        System.out.println(c);

        //返回c的父类加载器 -> 平台类加载器
        ClassLoader c1 = c.getParent();
        System.out.println(c1);

        //返回c1的父类加载器 -> 虚拟机的内置加载器
        //通常情况下表示为null
        ClassLoader c2 = c1.getParent();
        System.out.println(c2);
    }
}
