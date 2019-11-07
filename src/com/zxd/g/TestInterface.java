package com.zxd.g;

//测试类
public class TestInterface {

    public static void main(String[] args) {
        //通过多态进行实例化
        HelloInterface hello = new HelloImpl();
        hello.show();
        hello.show1();
        //接口中的静态方法只能被接口调用，不能被其实现类调用
        HelloInterface.show2();
    }
}
