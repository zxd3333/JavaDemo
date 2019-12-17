package com.zxd.basics.look08;

// 成员内部类
// 成员内部类跟成员变量同级别
// 成员内部类可以访问外部类的成员和方法
// 外部类访问成员内部类需要创建内部类的对象
public class MemberInnerDemo {

    public String name = "小黑";
    private int age = 3;

    public void eat(){
        System.out.println("外面吃");
    }

    class Inner{
        private int num = 10;
        public void show(){

            // 普通成员内部类调用外部类的成员方法和成员变量
            System.out.println(name + "," + age);
            eat();
        }
    }

    // 外部类调用普通成员内部类中的方法和属性
    public void method(){
        Inner inner = new Inner();
        inner.show();
        System.out.println(inner.num);
    }
}
