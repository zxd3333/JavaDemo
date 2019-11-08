package com.zxd.h;

//匿名内部类
public class OuterClassDemo3 {

    public void show(InterfaceDemo interfaceDemo){
        interfaceDemo.eat();
        interfaceDemo.sleep();
    }

    public static void main(String[] args) {

        //使用方式一
        OuterClassDemo3 outer = new OuterClassDemo3();
        //调用show()方法时需要传入一个InterfaceDemo对象，采用匿名内部类的方式实现
        //创建匿名内部类时，必须实现接口或抽象父类里的所有抽象方法
        outer.show(new InterfaceDemo() {
            @Override
            public void eat() {
                System.out.println("我要吃肉肉");
            }

            @Override
            public void sleep() {
                System.out.println("我能睡觉觉");
            }
        });

        //使用方式二，直接通过创建一个InterfaceDemo接口的匿名内部类的来实现接口
        InterfaceDemo interfaceDemo = new InterfaceDemo() {
            @Override
            public void eat() {
                System.out.println("我要吃肉肉");
            }

            @Override
            public void sleep() {
                System.out.println("我要睡觉觉");
            }
        };
        //调用方法
        interfaceDemo.eat();
        interfaceDemo.sleep();
    }
}
