package com.zxd.d;

//方法
public class MethodDemo {

    public static void main(String[] args) {
        //调用非静态方法
        //首先需要本类的对象
        MethodDemo d = new MethodDemo();
        //通过对象名.方法名(参数)进行调用
        d.method1();

        int m = d.method2();
        System.out.println("返回值为：" + m);

        d.method3(1);

        //第三个和第四个方法是重载方法
        int n = d.method3(10,20);
        System.out.println("返回值为：" + n);

        //调用静态方法
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

    //静态方法
    public static void method(){
        System.out.println("静态方法");
    }
}
