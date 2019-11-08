package com.zxd.h;

//局部内部类的使用
//局部内部类，在方法当中
public class OuterClassDemo2 {

    private int num = 100;

    //普通方法
    public void show(){
        int num = 50;
        //局部内部类，在方法中
        class Inner{
            public void innerShow(){
                System.out.println(num);
                //局部内部类中调用外部类的成员变量
                System.out.println(new OuterClassDemo2().num);
            }
        }

        //方法中使用局部内部类
        Inner inner = new Inner();
        inner.innerShow();
    }

    public static void main(String[] args) {
        OuterClassDemo2 outer = new OuterClassDemo2();
        outer.show();
    }
}
