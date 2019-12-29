package com.zxd.basics.look15.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 将接收到的数据写入文件
public class IOReceive {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(10086);
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\com\\zxd\\basics\\look15\\tcp\\b.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        //文件写入成功后给出反馈
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("文件上传成功");
        writer.newLine();
        writer.flush();
        writer.close();
        serverSocket.close();
    }
}
