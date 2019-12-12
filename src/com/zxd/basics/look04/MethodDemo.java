package com.zxd.basics.look04;

// 方法
public class MethodDemo {

    private int a = 100;
    private static int b =50;

    // main()方法也是静态方法
    public static void main(String[] args) {
        // 静态方法调用非静态成员变量和方法
        // 首先需要实例化类
        MethodDemo method = new MethodDemo();
        // 通过对象名.变量名调用成员变量
        System.out.println(method.a);
        // 直接调用静态变量
        System.out.println(b);

        // 通过对象名.方法名(参数)调用成员方法
        method.method1();

        int m2 = method.method2();
        System.out.println("返回值为：" + m2);

        method.method3(1);

        // 两个method3()传入参数个数不同，实现了方法的重载
        int m3 = method.method3(10,20);
        System.out.println("返回值为：" + m3);

        // method4()研究的是普通方法调用静态变量和方法
        method.method4();

        // 静态方法可以直接通过方法名调用静态方法
        method5();

        // 调用递归的方法
        int recursive = recursive(5);
        System.out.println(recursive);
    }

    public void method1(){
        System.out.println("这个方法： 无参  无返回值");
    }
    public int method2(){
        int i2 = 1;
        System.out.println("这个方法： 无参  有返回值");
        return i2;
    }
    public void method3(int a){
        System.out.println("这个方法： 带参  无返回值。" + "传入了：" + a );
    }
    public int method3(int a, int b){
        System.out.println("这个方法： 带参  有返回值");
        return a > b ? a : b;
    }
    // 普通方法
    public void method4(){
        // 普通方法可以直接调用类中的静态变量和成员变量
        System.out.println(a);
        System.out.println(b);
        // 普通方法可以通过方法名直接调用类中的普通方法和静态方法
        method1();
        method5();
    }

    // 静态方法
    public static void method5(){
        // 静态方法只能通过对象名.方法名调用普通方法
        MethodDemo m = new MethodDemo();
        m.method1();
        // 静态方法只能通过对象名.成员变量名调用成员变量
        System.out.println(m.a);
        // 静态方法可以直接调用静态变量
        System.out.println(b);
    }

    // 递归
    public static int recursive(int i){
        if (i == 1){
            return 1;
        }else {
            return i*recursive(i-1);
        }
    }
}
