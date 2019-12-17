package com.zxd.basics.look06.third;

// Cat 继承了 Animal
public class Cat extends Animal{

    public Cat(){
        // 当父类只有有参构造方法时要加上下面的代码
        // super("小黑");
        System.out.println("子类无参构造执行");
    }

    // 继承中this 和 super
    int num = 50;
    public void num(){
        int num = 25;

        // 就近原则
        System.out.println(num);  // 25

        // this代表本类对象的引用
        // 方法被哪个对象调用，this就代表哪个对象
        System.out.println(this.num);  // 50

        // super代表父类对象的引用
        System.out.println(super.num);   // 100
    }

    @Override
    public void eat(){
        System.out.println("小白抓老鼠吃");
    }

    public void see(){
        System.out.println("小白晚上可以看见");
    }
}
