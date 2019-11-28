package com.zxd.basics.m;

import java.io.*;

//标准输入输出流
public class InputStreamDemo {

    public static void main(String[] args) throws IOException {
//        InputStream is = System.in;
//        int by;
//        while((by = is.read())!=-1){
//            System.out.println((char)by);
//        }
        //按照上面的方法当输入中文字符时，使用字节流显然不能很好显示内容

        //于是我们提出了字符转换流InputStreamReader(),把字节流转换成字符流
        //但是考虑到多个汉字的情况，还是一行一行读数据比较好
        //于是就用到了字符缓冲输入流BufferedReader的readLine方法
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(s);
        //当输入数字的时候，用到了Integer包装类
        //直接这样会报错的
        //int i = br.readLine();
        //必须采用以下的方式写
        //int i = Integer.parseInt(br.readLine());
        //所以得出结论，输入什么类型的就用什么类型的包装类

        //通过以上的方法，我们可以看出自己写一个方法录入数据比较麻烦，所以Java提供了Scanner类
//
        //标准输出流：PrintStream
        PrintStream ps = System.out;
        ps.print(100); //运行后就会在控制台出现100
    }
}
