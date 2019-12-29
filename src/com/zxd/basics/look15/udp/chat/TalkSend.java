package com.zxd.basics.look15.udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TalkSend implements Runnable {

    DatagramPacket packet;
    DatagramSocket socket;
    BufferedReader reader;

    // 发送时指定的主机ip
    private String sendIP;
    // 发送时指定接收方的端口号
    private int sendPort;

    public TalkSend(String sendIP, int sendPort) {
        this.sendIP = sendIP;
        this.sendPort = sendPort;

        try {
            socket = new DatagramSocket();
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                String str = reader.readLine();
                byte[] data = str.getBytes();
                packet = new DatagramPacket(data,0,data.length, InetAddress.getByName(sendIP),sendPort);
                socket.send(packet);

                if (data.equals("886")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
