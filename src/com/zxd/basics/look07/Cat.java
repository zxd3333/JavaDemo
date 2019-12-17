package com.zxd.basics.look07;

// 继承了抽象类的子类必须重写父类的方法
public class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("小白抓老鼠吃");
    }
}
