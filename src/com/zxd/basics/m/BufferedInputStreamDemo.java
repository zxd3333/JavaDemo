package com.zxd.basics.m;

import java.io.*;

//字节缓冲输入输出流
//实现数据的高效写入和读取
public class BufferedInputStreamDemo {

    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\com\\zxd\\basics\\m\\IO流.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\com\\zxd\\basics\\m\\b.txt"));

        //方式一:一次读取一个字节
//        int ch;
//        while ((ch = bis.read()) != -1){
//            bos.write((char)ch);
//        }

        //添加数据
        bos.write("哈哈".getBytes());

        //方式二：一次读取一个字符数组
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }

        bos.close();
        bis.close();

    }
}
