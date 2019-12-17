package com.zxd.basics.look06.first;

// 测试类
public class AnimalTest {

    public static void main(String[] args) {

        // 实例化一个动物类的对象，不传参数
        Animal dog = new Animal();

        // 实例化Animal类时会调用默认的无参构造方法，并给属性赋予初始值
        System.out.println(dog.name + "," + dog.age);
        dog.eat();

        // 给dog的属性赋值
        dog.name = "小白";
        dog.age = 2;

        // 再次输出dog的属性和方法
        System.out.println(dog.name + "," + dog.age);
        dog.eat();

        // 实例化一个动物类的对象，传入参数
        Animal cat = new Animal("小黑",3);

        // 实例化Animal类时会调用默认的无参构造方法，并给属性赋予初始值
        System.out.println(cat.name + "," + cat.age);
        cat.eat();
    }
}
