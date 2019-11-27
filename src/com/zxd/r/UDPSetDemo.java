package com.zxd.r;

import java.io.IOException;
import java.net.*;

//了解UDP
//UDP发送数据
//运行时先运行接收端接受数据，再运行客户端发送数据
public class UDPSetDemo {

    public static void main(String[] args) throws IOException {
        //1.创建发送数据的Socket对象
        DatagramSocket socket = new DatagramSocket();
        //2.创建数据，并把数据打包
        //构造一个数据包，该数据包需要发送长度为length的数据包到指定主机的指定端口号
        byte[] data = "UDP初步学习".getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length,
                InetAddress.getByName("192.168.1.105"),10086);
        //3.Socket对象调用send()方法发送数据包
        socket.send(packet);
        //4.关闭发送端
        socket.close();
    }
}
