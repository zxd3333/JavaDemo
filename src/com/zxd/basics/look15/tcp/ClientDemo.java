package com.zxd.basics.look15.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// TCP客户端
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        // 1.创建客户端的Socket对象
        Socket socket = new Socket("192.168.1.105",8520);
        // 2.获取输出流
        OutputStream os = socket.getOutputStream();
        // 3.写数据
        os.write("客户端写的东西".getBytes());

        // 4.接收服务端的反馈
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));

        // 5.关闭连接
        socket.close();

    }
}
