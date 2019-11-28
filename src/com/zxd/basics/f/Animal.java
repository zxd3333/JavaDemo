package com.zxd.basics.f;

//父类
public class Animal {

    //第一部分：定义动物类的属性和行为
    public String name;
    public int age;

    public void eat(){
        System.out.println("动物会吃东西");
    }
    public void run(){
        System.out.println("动物会跑");
    }

    //第二部分：研究子类父类构造方法的执行顺序
    public Animal(){
        System.out.println("父类--无参构造执行");
    }
    public Animal(String name, int age){
        System.out.println("父类--带参构造执行");
    }
    static {
        System.out.println("父类--静态代码块执行");
    }
    {
        System.out.println("父类--普通代码块执行");
    }

    //第三部分：研究继承中的变量访问顺序
    int num = 40;

    //第四部分：
    //新增属性
    public int foot = 2;
}
