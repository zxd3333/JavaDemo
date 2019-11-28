package com.zxd.basics.m;

import java.io.*;

//转换流
//字符 -> 字节 :OutputStreamWriter
//字节 -> 字符 :InputStreamReader
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {

        //OutputStreamWriter：将写入的字符转换成字节
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src\\com\\zxd\\basics\\m\\e.txt"));
        osw.write("信号");
        osw.flush();
        osw.close();

        //InputStreamReader：将文件中的字节转换成字符并输出
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src\\com\\zxd\\basics\\m\\e.txt"));
        //方式一
        int ch;
        while ((ch = isr.read())!=-1){
            System.out.print((char)ch);
        }
        isr.close();
        //方式二
//        char[] chs = new char[1024];
//        int len;
//        while((len = isr.read(chs))!= -1){
//            System.out.println(new String(chs,0,len));
//        }
//        isr.close();
    }
}
