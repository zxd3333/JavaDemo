package com.zxd.basics.r;

import java.net.InetAddress;
import java.net.UnknownHostException;

//网络编程
public class InternetDemo {

    public static void main(String[] args) throws UnknownHostException {
        //InetAddress：此类表示IP地址
        //因为InetAddress没有构造方法，所以我们采用InetAddress.getByName()方法得到InetAddress的一个对象
        //方法参数可以是计算机名称或者IP地址，推荐IP地址
        InetAddress address = InetAddress.getByName("192.168.1.105");
        //得到该address对象的主机名
        System.out.println(address.getHostName());
        //得到该address对象的IP地址
        System.out.println(address.getHostAddress());
    }
}
