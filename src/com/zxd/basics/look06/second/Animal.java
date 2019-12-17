package com.zxd.basics.look06.second;

// 封装
// 一般用法，类中属性通过private关键字标记为私有，对外界提供get/set方法操作属性
// 可以在set方法中添加一些判断内容进行过滤
public class Animal {

    // private修饰属性，就是不想让你直接对属性进行操作
    private String name;
    private int age;

    // 由于不能直接对属性进行操作，所欲需要提供一些方法来供用户访问
    // get/set 就产生了

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 构造方法
    public Animal(){

    }

    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }
}
