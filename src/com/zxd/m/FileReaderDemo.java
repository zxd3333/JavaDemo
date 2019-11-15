package com.zxd.m;

import java.io.*;

//字符输入输出流
//字符流出现的原因：当数据中有中文存在时，字节流操作中文不方便
//而字节流复制文件时，即使文件中有中文也能复制成功，这是因为有底层进行相关操作
public class FileReaderDemo {

    public static void main(String[] args) throws IOException {

        //直接使用字节输出流输出文件内容，如果文件中有中文，那么会输出为乱码
        //因为一个中午占用了2个字节（GBK）或者3个字节（UTF-8）
        //所以会出现乱码
        FileInputStream fileInputStream = new FileInputStream("src\\com\\zxd\\m\\c.txt");

        int ch;
        while ((ch = fileInputStream.read()) != -1){
            System.out.print((char) ch);
        }
        fileInputStream.close();

        System.out.println();

        //写入数据
        FileWriter fw = new FileWriter("src\\com\\zxd\\m\\c.txt");
        fw.write("Hello,这是FileWriter写入的数据");
        fw.close();

        //读取数据
        FileReader fr = new FileReader("src\\com\\zxd\\m\\c.txt");
        //方法一：一次读取一个字符
//        int ch;
//        while ((ch = fr.read()) != -1){
//            //输出语句不要加 ln
//            System.out.print((char)ch);
//        }
//        fr.close();

        //读数据方法二：一次读取一个字符数组
        char[] c = new char[1024];
        int len;
        while((len = fr.read(c)) != -1){
            System.out.print(new String(c,0,len));
        }
        fr.close();
    }
}
