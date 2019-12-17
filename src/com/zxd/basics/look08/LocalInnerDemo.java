package com.zxd.basics.look08;

// 局部内部类
// 局部内部类在方法当中
public class LocalInnerDemo {

    private int num = 10;

    public void method(){
        int num = 20;
        class Inner{
            public void show(){
                // 访问方法中的变量
                System.out.println(num);
                // 访问外部类中的变量
                System.out.println(new LocalInnerDemo().num);
            }
        }

        // 方法中访问局部内部类
        Inner inner = new Inner();
        inner.show();
    }

}
