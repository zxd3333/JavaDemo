package com.zxd.basics.g;

//接口的实现类
public class HelloImpl implements HelloInterface {
    //必须重写抽象方法
    @Override
    public void show() {
        System.out.println("接口实现类重写了抽象方法");
    }

    //可以重写默认方法，也可以不重写
    @Override
    public void show1(){
        System.out.println("接口实现类重写了默认方法");
    }
}
