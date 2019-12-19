package com.zxd.basics.look13.staticProxy;

// 静态代理
// 可以看出一些弊端，举例说明
// 加入又来了一个人要出租自己的房子，但是他有很多要求，于是为了帮他，就要重新编写一个房东类实现租房接口
// 同时又要编写一个代理类帮他租房
// 要是来了很多人，要求又不一样，就需要很多代码才能完成了
// 这显然与懒惰的程序员不符，于是动态代理就出现了，至于什么是动态代理，之后再说吧。
public class StaticProxy {
    public static void main(String[] args) {
        // 房东说要出租房子了，那就先获取一个房东对象
        Host host = new Host();
        // 中介帮房东出租，需要传入一个参数来表示给谁出租房子
        Agency agency = new Agency(host);
        // 调用租房的方法
        agency.rent();
    }
}
