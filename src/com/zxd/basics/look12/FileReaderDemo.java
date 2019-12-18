package com.zxd.basics.look12;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 字符输入输出流
// 字符输入流 -> FileReader -> 读数据
// 字符输出流 -> FileWriter -> 写数据
public class FileReaderDemo {

    public static void main(String[] args) throws IOException {

        // 写入数据
        FileWriter fw = new FileWriter("src\\com\\zxd\\basics\\look12\\StaticFile\\c.txt",true);
        fw.write("FileWriter可以直接写字符串呦");
        fw.close();

        // 读数据
        FileReader fr = new FileReader("src\\com\\zxd\\basics\\look12\\StaticFile\\c.txt");

        // 方式一：一次读取一个字符
//        int ch;
//        while ((ch = fr.read()) != -1){
//            System.out.print((char)ch);
//        }
//        fr.close();

        // 方式二：一次读取一个字符数组
        char[] chars = new char[1024];
        int len;
        while ((len = fr.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }
    }
}
