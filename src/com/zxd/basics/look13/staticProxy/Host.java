package com.zxd.basics.look13.staticProxy;

// 静态代理
// 真实角色
// 房东要出租自己的租房，那他就要实现租房的接口表明他要租房
public class Host implements Rent{

    @Override
    public void rent() {
        System.out.println("我是某个房子的主人，我要出租自己的房子");
    }
}
