package com.zxd.g;

//测试类
public class TestAbstract {

    public static void main(String[] args) {
        //Animal是抽象类，抽象类不能实例化
        //但是可以通过多态(父类引用指向子类对象)进行实例化
        Animal animal = new Cat("小猫");
        System.out.println(animal.getName());
        animal.eat();
        //可以通过 类名.方法名() 直接调用抽象类中的静态方法
        Animal.show();
    }
}
