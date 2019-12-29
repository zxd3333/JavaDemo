package com.zxd.basics.look15.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// TCP服务端
public class ServerDemo {

    public static void main(String[] args) throws IOException {

        // 1.创建接收端的Socket对象
        ServerSocket socket = new ServerSocket(10086);
        // 2.监听客户端连接
        Socket s = socket.accept();
        // 3.获取输入流用于读取数据
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        // 5.给出反馈
        OutputStream os = s.getOutputStream();
        os.write("服务端接收到数据了".getBytes());
        // 6.关闭连接
        socket.close();
    }
}
