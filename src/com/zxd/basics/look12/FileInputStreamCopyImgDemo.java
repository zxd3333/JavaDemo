package com.zxd.basics.look12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 复制图片
public class FileInputStreamCopyImgDemo {

    public static void main(String[] args) throws IOException {

        // 先读取图片，再把图片写入
        FileInputStream fis = new FileInputStream("src\\com\\zxd\\basics\\look12\\StaticFile\\soul.png");
        FileOutputStream fos = new FileOutputStream("src\\com\\zxd\\basics\\look12\\StaticFile\\soulCopy.png");

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }

        fis.close();
        fos.close();
    }
}
