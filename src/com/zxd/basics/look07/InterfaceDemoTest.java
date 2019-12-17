package com.zxd.basics.look07;

// 测试类
public class InterfaceDemoTest {

    public static void main(String[] args) {

        // 通过多态创建接口对象
        Hello hello = new HelloImpl();

        // 调用方法，访问的是实现类重写的方法。这件只是一句废话哈哈哈
        hello.say();
        hello.see();

        World world = new HelloImpl();
        world.call();
    }
}
