package com.zxd.f;

public class Cat extends Animal {

    //第二部分：研究子类父类构造方法的执行顺序
    public Cat(){
        System.out.println("子类--无参构造执行");
    }
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("子类--带参构造执行");
    }
    static{
        System.out.println("子类--静态代码块执行");
    }
    {
        System.out.println("子类--普通代码块执行");
    }

    //第三部分：研究继承中的变量访问顺序
    int num = 30;
    public void show(){
        int num = 20;
        //就近原则
        System.out.println(num);  //20
        //this代表所在类的对象的引用，方法被哪个对象调用，this就代表哪个对象
        System.out.println(this.num);  //30
        //super代表父类对象的引用
        System.out.println(super.num);  //40
    }

    //第四部分：子类重写父类的属性和方法
    String name = "喵喵";
    int age = 20;
    @Override
    public void eat(){
        System.out.println("小猫吃老鼠");
    }

    @Override
    public void run(){
        System.out.println("小猫可以跑");
    }

    //子类独有的方法
    public void see(){
        System.out.println("小猫可以看见东西");
    }
}
