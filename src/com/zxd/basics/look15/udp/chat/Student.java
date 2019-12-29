package com.zxd.basics.look15.udp.chat;

// udp聊天
public class Student {

    public static void main(String[] args) {
        new Thread(new TalkSend("192.168.1.105",6666)).start();
        new Thread(new TalkReceive(5555,"赵老师")).start();
    }
}
