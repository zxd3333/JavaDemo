package com.zxd.basics.g;

//子类继承抽象类，必须实现抽象类中所有的抽象方法
public class Cat extends Animal {

    public Cat(){

    }
    public Cat(String name){
        super(name);
    }
    @Override
    public void eat() {
        System.out.println("小猫吃小老鼠");
    }
}
