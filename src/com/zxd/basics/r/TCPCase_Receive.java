package com.zxd.basics.r;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//TCP通信案例之接受数据
public class TCPCase_Receive {

    public static void main(String[] args) throws IOException {
        //1.将数据在控制台输出
//        ServerSocket serverSocket = new ServerSocket(10086);
//        Socket socket = serverSocket.accept();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String line;
//        while ((line = reader.readLine())!=null){
//            System.out.println(line);
//        }
//        serverSocket.close();

        //2.将数据保存在文本文件当中
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket s = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\com\\zxd\\r\\a.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            writer.write(line);
            writer.newLine();
            writer.flush();
        }
        //文件写入成功后给出反馈
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write("文件上传成功");
        bw.newLine();
        bw.flush();
        serverSocket.close();
    }
}
