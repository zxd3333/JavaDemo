package com.zxd.basics.look15;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/hi/index.jsp?username=root&pwd=root");
        System.out.println(url.getProtocol());  // 协议 http
        System.out.println(url.getHost());  // 主机 localhost
        System.out.println(url.getPort());  // 端口号 8080
        System.out.println(url.getPath());  // 文件 /hi/index.jsp
        System.out.println(url.getFile());  // 全路径 /hi/index.jsp?username=root&pwd=root
        System.out.println(url.getQuery());  // 参数 username=root&pwd=root

        // 通过url下载
        URL u = new URL("https://m10.music.126.net/20191229131653/632ca4b2c468bd074880d67b202e5dd9/yyaac/0753/0e0b/5409/0993aabc2b9ad35b9613cc5f7818f8f8.m4a");
        // 连接到资源
        HttpURLConnection connection = (HttpURLConnection) u.openConnection();
        InputStream inputStream = connection.getInputStream();
        FileOutputStream fos = new FileOutputStream("src\\com\\zxd\\basics\\look15\\a.m4a");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fos.close();
        inputStream.close();
        connection.disconnect();
    }
}
