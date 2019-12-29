package com.zxd.basics.look15.tcp;

import java.io.*;
import java.net.Socket;

// 通信之客户端发送数据
public class SendDemo {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.1.105",10086);
        // 读取写入的数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 获取输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            if (line.equals("886")){
                break;
            }else {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }

        socket.shutdownOutput();
    }
}
