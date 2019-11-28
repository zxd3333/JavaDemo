package com.zxd.basics.d;

//方法
public class MethodDemo {

    private int a = 100;
    private static int b =50;

    public static void main(String[] args) {
        //静态方法调用非静态成员变量和方法
        //首先需要实例化类
        MethodDemo d = new MethodDemo();
        //通过对象名.变量名调用成员变量
        System.out.println(d.a);
        //直接调用静态变量
        System.out.println(b);
        //通过对象名.方法名(参数)调用成员方法
        d.method1();

        int m = d.method2();
        System.out.println("返回值为：" + m);

        d.method3(1);

        //第三个和第四个方法是重载方法
        int n = d.method3(10,20);
        System.out.println("返回值为：" + n);

        //第五个方法
        //研究的是普通方法调用静态变量和方法
        d.method4();

        //直接调用静态方法
        method();
    }

    public void method1(){
        System.out.println("这个方法： 无参  无返回值");
    }
    public int method2(){
        System.out.println("这个方法： 无参  有返回值");
        return 1;
    }
    public void method3(int a){
        System.out.println("这个方法： 带参  无返回值");
    }
    public int method3(int a, int b){
        System.out.println("这个方法： 带参  有返回值");
        return a > b ? a : b;
    }
    public void method4(){
        System.out.println(a);
        System.out.println(b);
        method1();
        method();
    }

    //静态方法
    public static void method(){
        System.out.println("静态方法");
    }
}
