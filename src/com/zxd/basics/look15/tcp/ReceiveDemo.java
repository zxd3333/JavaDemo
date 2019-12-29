package com.zxd.basics.look15.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 通信之服务端接收数据
public class ReceiveDemo {

    public static void main(String[] args) throws IOException {
        // 1.将数据在控制台输出
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }

        reader.close();
        socket.close();
        serverSocket.close();
    }
}
