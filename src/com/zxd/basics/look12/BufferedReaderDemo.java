package com.zxd.basics.look12;

import java.io.*;

// 字符缓冲输入输出流
// 比FileReader 和FileWriter 高效
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {

        // 写入数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\com\\zxd\\basics\\look12\\StaticFile\\d.txt",true));
        bw.write("BufferedWriter写入的数据");
        // BufferedWriter独有的换行的方法
        // 该方法会调用系统默认的换行符
        // 不提倡使用，因为不同的操作系统的换行符不同，切换操作系统时可能会出错
        bw.newLine();
        bw.close();

        // 读取数据的时候有新的方法
        BufferedReader br = new BufferedReader(new FileReader("src\\com\\zxd\\basics\\look12\\StaticFile\\d.txt"));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }
}
