package com.zxd.basics.look15.udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {

    DatagramSocket socket;
    DatagramPacket packet;

    // 用于接收的的端口
    private int port;
    // 指定说话的人
    private String people;

    public TalkReceive(int port,String people) {
        this.port = port;
        this.people = people;

        try {
            // 创建接收端的Socket对象，指定发送端的端口号
            socket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 创建死循环，可以一直接收数据
        while (true){
            try {
                // 创建字节数组用来存储数据
                byte[] data = new byte[1024];
                // 创建一个数据包来接收数据
                packet = new DatagramPacket(data,data.length);
                // 调用方法接收数据
                socket.receive(packet);
                // 从数据包中拿到数据
                byte[] data2 = packet.getData();
                int len = data2.length;
                String receiveData = new String(data2,0,len);
                // 输出数据到控制台
                System.out.println(people + "说：" + receiveData);
                if (receiveData.equals("886")){
                    break;
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
