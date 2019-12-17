package com.zxd.basics.look07;

// 接口的实现类
// 接口实现类可以实现多个接口
// 实现了多少接口就必须重写那些接口中的所有方法
public class HelloImpl implements Hello,World{
    @Override
    public void say() {
        System.out.println("Hello");
    }

    @Override
    public void see() {
        System.out.println("See You");
    }

    @Override
    public void call() {
        System.out.println("Call Me");
    }
}
