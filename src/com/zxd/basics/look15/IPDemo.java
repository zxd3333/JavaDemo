package com.zxd.basics.look15;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 网络编程
public class IPDemo {

    public static void main(String[] args) throws UnknownHostException {
        // InetAddress：此类表示IP地址
        // 因为InetAddress没有构造方法，这里采用InetAddress.getByName()方法得到InetAddress的一个对象
        // 方法参数可以是计算机名称或者IP地址，推荐IP地址
        InetAddress address1 = InetAddress.getByName("192.168.1.105");
        InetAddress address2 = InetAddress.getByName("localhost");
        System.out.println(address1 + "," + address2);

        // 得到address对象的主机名
        System.out.println(address1.getHostName());

        // 得到address对象的IP地址
        System.out.println(address1.getHostAddress());
    }
}
