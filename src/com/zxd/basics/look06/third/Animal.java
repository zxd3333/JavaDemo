package com.zxd.basics.look06.third;

// 继承
public class Animal {

    private String name;
    private int age;

    public Animal(){
        System.out.println("父类无参构造执行");
    }

    public Animal(String name){
        System.out.println("父类有参构造执行");
    }

    // 继承中this 和 super的使用
    int num = 100;

    public void run(){
        System.out.println("动物会跑");
    }

    private void have(){
        System.out.println("动物有很多种类");
    }

    public void eat(){
        System.out.println("动物会吃东西");
    }

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
}
