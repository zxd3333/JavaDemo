package com.zxd.r;

import java.io.*;
import java.net.Socket;

//TCP通信练习之发送端
public class TCPCase_Send {

    public static void main(String[] args) throws IOException {

        //1.发送数据到服务器
        //客户端对应TCPCase_Receive的 1 和 2
//        Socket socket = new Socket("192.168.1.105",10086);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        String line;
//        while((line = reader.readLine()) != null){
//            if (line.equals("886")){
//                break;
//            }else {
//                writer.write(line);
//                writer.newLine();
//                writer.flush();
//            }
//        }
//        socket.shutdownOutput();
//        //发送成功后接受服务器的反馈
//        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        System.out.println("服务器的反馈是：" + br.readLine());
//        br.close();
//        socket.close();

        //2.从文件读取数据，并在服务端把数据写入另一个文件
        //客户端对应的TCPCase_Receive的 2
        Socket socket = new Socket("192.168.1.105",10086);
        BufferedReader reader = new BufferedReader(new FileReader("src\\com\\zxd\\r\\b.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line = reader.readLine()) != null){
            writer.write(line);
            writer.newLine();
            writer.flush();
        }
        //先前写入的数据将被发送，然后是Tcp终止序列
        //就是一个发送结束的标记
        socket.shutdownOutput();
        //发送成功后接受服务器的反馈
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("服务器的反馈是：" + br.readLine());
        br.close();

        socket.close();

    }
}
