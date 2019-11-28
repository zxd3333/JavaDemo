package com.zxd.basics.f;

public class ClassDemo {

    public static void main(String[] args) {
        //第一部分：初步使用动物类
        Animal animal = new Animal();
        animal.name = "小鸟";
        animal.age = 22;
        System.out.println(animal.name + "今年" + animal.age + "岁了.");
        animal.eat();
        animal.run();

        //第三部分：研究继承中的变量访问顺序
        Cat cat = new Cat();
        cat.show();

        //第四部分：多态
        Animal a = new Cat();
        //多态访问成员变量,实际上访问的是父类的成员变量
        System.out.println(a.foot);  // 2
        System.out.println(a.name);  // 父类没有定义，默认为 null
        //多态访问成员方法，实际上访问的是子类重写的方法
        a.eat();
        a.run();
        // a.see();  对于子类独有的方法,父类的引用是无法访问的
        //为了可以访问子类独有的方法，只能将父类引用强制转换为子类对象了
        Cat c = (Cat) a;
        c.see();

    }
}
