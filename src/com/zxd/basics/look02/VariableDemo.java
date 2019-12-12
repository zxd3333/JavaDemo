package com.zxd.basics.look02;

// 变量
// 类变量：被static修饰的变量，定义在类中方法外
// 成员变量：可以定义在类中和方法中
// 局部变量：定义在方法中
public class VariableDemo {

    // 类变量
    static int a = 100;

    // 成员变量
    int b = 200;

    public static void main(String[] args) {
        //调用method()方法
        method();
    }

    public static void method(){

        // 局部变量
        int c = 300;

        // 访问类变量
        System.out.println(a);

        // 访问成员变量
        VariableDemo variable = new VariableDemo();
        System.out.println(variable.b);

        // 访问局部变量
        System.out.println(c);
    }
}
