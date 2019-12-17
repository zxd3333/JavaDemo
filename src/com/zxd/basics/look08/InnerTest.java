package com.zxd.basics.look08;

// 测试类
public class InnerTest {

    public static void main(String[] args) {
        // 访问成员内部类中的方法
        MemberInnerDemo.Inner inner = new MemberInnerDemo().new Inner();
        inner.show();
        // 通过外部类的方法访问成员内部类
        MemberInnerDemo memberInnerDemo = new MemberInnerDemo();
        memberInnerDemo.method();


        // 访问局部内部类中的方法
        LocalInnerDemo localInnerDemo = new LocalInnerDemo();
        localInnerDemo.method();
    }
}
