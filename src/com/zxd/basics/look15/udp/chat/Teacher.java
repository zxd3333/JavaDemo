package com.zxd.basics.look15.udp.chat;

// udp聊天
public class Teacher {
    public static void main(String[] args) {
        new Thread(new TalkSend("192.168.1.105",5555)).start();
        new Thread(new TalkReceive(6666,"梁子")).start();
    }
}
