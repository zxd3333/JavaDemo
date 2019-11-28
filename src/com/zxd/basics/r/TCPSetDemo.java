package com.zxd.basics.r;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//了解TCP
//TCP发送数据
//运行时先运行接收端接受数据，再运行客户端发送数据
public class TCPSetDemo {

    public static void main(String[] args) throws IOException {
        //创建发送端(客户端)的Socket对象，指定主机和端口号
        Socket socket = new Socket("192.168.1.105",10086);
        //获取输出流写数据
        OutputStream os = socket.getOutputStream();
        os.write("TCP初步学习".getBytes());
        //接收接收端(服务器)的反馈
        InputStream is = socket.getInputStream();
        //获得反馈内容
        byte[] data = new byte[1024];
        int len = is.read(data);
        System.out.println(new String(data,0,len));
        socket.close();
        os.close();
    }
}
