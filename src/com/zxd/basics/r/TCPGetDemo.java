package com.zxd.basics.r;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//TCP读取数据
public class TCPGetDemo {

    public static void main(String[] args) throws IOException {
        //创建接收端(服务器)的ServerSocket对象，指定端口号
        ServerSocket serverSocket = new ServerSocket(10086);
        //监听发送端(客户端)连接，返回一个Socket对象
        Socket s = serverSocket.accept();
        //获取输入流，读取数据
        InputStream is = s.getInputStream();
        byte[] data = new byte[1024];
        int len = is.read(data);
        System.out.println(new String(data,0,len));
        //给出反馈
        OutputStream os = s.getOutputStream();
        os.write("数据接收到了".getBytes());
        serverSocket.close();
    }
}
