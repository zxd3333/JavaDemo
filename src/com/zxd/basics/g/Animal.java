package com.zxd.basics.g;

//抽象类
//抽象类中不一定有抽象方法
//但是如果一个类中有抽象方法，那么这个类必须被声明为抽象类
public abstract class Animal {

    private String name;

    //抽象类的构造方法是为了属性的初始化
    //而且子类对象实例化的时候，依然会先执行父类的构造方法
    public Animal(){

    }
    public Animal(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void show(){
        System.out.println("抽象类中的静态方法");
    }

    //抽象方法
    public abstract void eat();
}
