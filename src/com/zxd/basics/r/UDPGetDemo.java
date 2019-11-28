package com.zxd.basics.r;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//了解UDP
//UDP接收数据
public class UDPGetDemo {

    public static void main(String[] args) throws IOException {
        //1.创建接收数据的Socket对象,并且需要指定端口,要跟发送端的端口一致
        DatagramSocket resultSocket = new DatagramSocket(10086);
        //2.创建一个数据包用于接收数据
        byte[] data = new byte[1024];
        //构造一个用于接收长度为length的数据包
        DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
        //3.调用方法接收数据
        resultSocket.receive(datagramPacket);
        //4.解析数据包，即从数据包中拿到数据
        byte[] resultData = datagramPacket.getData();
        //通过getLength()方法得到数据的长度
        int len = datagramPacket.getLength();
        //将字节数组的数据转换成字符串
        String s = new String(resultData,0,len);
        System.out.println(s);
        //5.关闭接收端
        resultSocket.close();
    }
}
