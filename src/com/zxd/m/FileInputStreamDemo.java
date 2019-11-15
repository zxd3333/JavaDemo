package com.zxd.m;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//字节文件输入输出流
//FileInputStream:文件输入流，读取数据
//FileOutputStream:文件输出流，写入数据
public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {

        //写入数据
        //如果没有true,就是覆盖文件内容并重新写入
        //如果有true,就是在文件内容之后追加写入
        FileOutputStream fos = new FileOutputStream("src\\com\\zxd\\m\\a.txt",true);
        //在文件中写入内容，数字会转化成ASCII对应的内容
        fos.write(101);
        //使用之后需要关闭
        fos.close();

        //读取数据
        FileInputStream fis = new FileInputStream("src\\com\\zxd\\m\\a.txt");
        //方式一：一次读取一个字节
        int ch;
        while ((ch = fis.read()) != -1){
            System.out.print((char)ch);
        }
        fis.close();

        System.out.println();

        //方式二：一次读取一个字符数组
//        FileInputStream fis1 = new FileInputStream("src\\com\\zxd\\m\\a.txt");
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = fis1.read(bytes)) != -1){
//            System.out.println(new String(bytes,0,len));
//        }
//        fis1.close();

        //通过字节输入输出流复制图片
        FileInputStream inputStream = new FileInputStream("src\\com\\zxd\\m\\soul.png");
        FileOutputStream outputStream = new FileOutputStream("src\\com\\zxd\\m\\soulCopy.png");
        byte[] imgByte = new byte[1024];
        int len;
        while ((len = inputStream.read(imgByte)) != -1){
            outputStream.write(imgByte,0,len);
        }
        inputStream.close();
        outputStream.close();
    }
}
