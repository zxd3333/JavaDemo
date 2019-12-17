package com.zxd.basics.look07;

public class AbstractDemoTest {

    public static void main(String[] args) {

        // 通过多态创建抽象类的实例
        Animal a = new Cat();

        // 调用的是子类中的方法
        a.eat();

        // 通过类名直接调用静态方法
        Animal.run();

    }
}
