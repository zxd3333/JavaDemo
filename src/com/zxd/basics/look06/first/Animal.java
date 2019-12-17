package com.zxd.basics.look06.first;

// 了解面向对象
// 动物类
public class Animal {

    // 动物具有的属性
    String name;  // 初始值为 null
    int age;  // 初始值为 0

    // 构造方法，顾名思义 -> 构造对象的方法
    // 无参构造，如果不写无参构造，系统会默认给一个无参构造
    public Animal(){

    }

    // 有参构造，需要自己创建
    // 如果编写了有参构造，系统就不会再提供无参构造，需要自己编写无参构造
    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }

    // 动物具有的方法
    public void eat(){
        System.out.println(name + "会吃东西");
    }
}
