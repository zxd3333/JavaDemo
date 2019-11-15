package com.zxd.m;

import java.io.*;

//字符缓冲流
//为了简化书写，读取字符文件时我们可以使用FileWriter和FileReader代替
//为了提高效率，提供了字符缓冲流BufferedWriter和BufferedReader
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {
        //写入数据
        //BufferedWriter bw = new BufferedWriter(new FileWriter("src\\com\\zxd\\m\\c.txt"));
        //BufferedWriter独有的换行的方法
        //该方法会调用系统默认的换行符
        //不提倡使用，因为不同的操作系统的换行符不同，切换操作系统时可能会出错
        //bw.newLine();
        //bw.close();

        //字符缓冲流读取数据的时候有新的方法
        BufferedReader br = new BufferedReader(new FileReader("src\\com\\zxd\\m\\c.txt"));
        String line;
        //readline() 一次读取一行数据
        while((line = br.readLine()) != null){
            //这个加了 ln 起到换行的作用
            System.out.println(line);
        }
        br.close();
    }
}
