package com.zxd.basics.look15.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveDemo {

    public static void main(String[] args) throws IOException {

        // 创建接收端的Socket对象，指定发送端的端口号
        DatagramSocket socket = new DatagramSocket(10086);
        // 创建死循环，可以一直接收数据
        while (true){
            // 创建字节数组用来存储数据
            byte[] data = new byte[1024];
            // 创建一个数据包来接收数据
            DatagramPacket packet = new DatagramPacket(data,data.length);
            // 调用方法接收数据
            socket.receive(packet);
            // 将字节数组转换成字符串后输出到控制台
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        }
    }
}
