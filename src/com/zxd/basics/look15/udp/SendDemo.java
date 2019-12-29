package com.zxd.basics.look15.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {

    public static void main(String[] args) throws IOException {

        // 创建发送端的Socket对象
        DatagramSocket socket = new DatagramSocket();
        // 从键盘录入数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = reader.readLine()) != null){
            // 如果输入886，就在发送完毕后跳出循环，发送端就不再发送数据
            if (line.equals("bye")){
                byte[] data = line.getBytes();
                DatagramPacket packet = new DatagramPacket(data,data.length,
                        InetAddress.getByName("192.168.1.105"),10086);
                socket.send(packet);
                break;
                // 如果输入的不是886，就创建字节数组接收键盘输入，并把数据打包发送到指定主机的指定端口
            }else {
                byte[] data = line.getBytes();
                DatagramPacket packet = new DatagramPacket(data,data.length,
                        InetAddress.getByName("192.168.1.105"),10086);
                socket.send(packet);
            }
        }
        // 关闭发送端
        socket.close();
    }
}
