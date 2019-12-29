package com.zxd.basics.look15.tcp;

import java.io.*;
import java.net.Socket;

// 文件中读取数据并发送
public class IOSend {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.1.105",10086);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\com\\zxd\\basics\\look15\\tcp\\a.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        socket.shutdownOutput();

        //发送成功后接受服务器的反馈
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("服务器的反馈是：" + reader.readLine());
        reader.close();

        socket.close();
    }
}
