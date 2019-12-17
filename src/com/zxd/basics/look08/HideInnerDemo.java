package com.zxd.basics.look08;

// 匿名内部类的使用
public class HideInnerDemo {

    // 类中的方法，传入参数为接口对象
    public void show(HideInterface hideInterface){
        hideInterface.say();
        hideInterface.see();
    }

    public static void main(String[] args) {

        HideInnerDemo demo = new HideInnerDemo();

        // 调用类中的show方法需要传入一个接口对象，这个接口对象通过匿名内部类的方式实现
        demo.show(new HideInterface() {
            @Override
            public void say() {
                System.out.println("Interface-Hello");
            }

            @Override
            public void see() {
                System.out.println("Interface-See You");
            }
        });

        // 方法二：直接通过匿名内部类创建一个接口对象
        HideInterface hideInterface = new HideInterface() {
            @Override
            public void say() {
                System.out.println("Interface-Hello");
            }

            @Override
            public void see() {
                System.out.println("Interface-See You");
            }
        };
        // 调用方法
        hideInterface.say();
        hideInterface.see();
    }
}
