package com.zxd.basics.k;

//泛型类测试类
public class TClassTest {

    public static void main(String[] args) {
        //使用时T会随着指定类型的变化而变化
        //实例化泛型类的时候要指定T的类型
        TClassDemo<Integer> t1 = new TClassDemo<>();
        t1.setT(100);
        System.out.println(t1.getT());
        t1.show("hello");

        TClassDemo<String> t2 = new TClassDemo<>();
        t2.setT("hello");
        System.out.println(t2.getT());
        t2.show(122);

        //不指定类型时，可以为任意类型
        TClassDemo t3 = new TClassDemo();
        t3.setT("Hi");
        System.out.println(t3.getT());
        t3.show(123);
    }
}
