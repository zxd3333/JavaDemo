package com.zxd.basics.look12;

import java.io.*;

// 转换流
// OutputStreamWriter(转换流) -> 字符转成字节
// InputStreamReader(转换流) -> 字节转成字符
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {
        // 将写入的字符转成字节
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
                "src\\com\\zxd\\basics\\look12\\StaticFile\\e.txt",
                true));
        osw.write("转换流");
        osw.flush();
        osw.close();

        // 将文件中的字节转换成字符输出
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src\\com\\zxd\\basics\\look12\\StaticFile\\e.txt"));
        // 方式一：一次读取一个字符
//        int ch;
//        while ((ch = isr.read()) != -1){
//            System.out.println((char)ch);
//        }
//        isr.close();
        // 方式二：一次读取一个字符数组
        char[] chars = new char[1024];
        int len;
        while ((len = isr.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }
        isr.close();
    }
}
