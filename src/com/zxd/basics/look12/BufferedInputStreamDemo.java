package com.zxd.basics.look12;

import java.io.*;

// 字节缓冲输入输出流
// 实现数据的高效读取和写入
public class BufferedInputStreamDemo {

    public static void main(String[] args) throws IOException {

        // 写入数据
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(
                "src\\com\\zxd\\basics\\look12\\StaticFile\\b.txt",
                true));
        String str = "BufferedOutputStream写入的数据";

        // 依旧只能写入byte[]和int类型的数据，可以通过String的getBytes()方法将字符串转化成字节数组
        bos.write(str.getBytes());
        bos.close();

        // 读取数据
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                "src\\com\\zxd\\basics\\look12\\StaticFile\\b.txt"));
        // 依旧有两种方式可以读取数据
        // 方式一：一次读取一个字符
        // 如果有中文，则会出现乱码
        // 因为一个中文字符占用了2个字节（GBK）或者3个字节（UTF-8）
        // 所以会出现乱码
//        int ch;
//        while ((ch = bis.read()) != -1){
//            System.out.print((char)ch);
//        }

        // 方式二：一次读取一个字节数组
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }

        bis.close();
    }
}
