package com.zxd.basics.look12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 文件字节输入流 -> 读取数据 -> FileInputStream
// 文件字节输出流 -> 写入数据 -> FileOutputStream
public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        // 写数据
        // 传入true则会在文件内容之后添加写入的内容
        // 不传true写入的数据会覆盖文件内容
        FileOutputStream fos = new FileOutputStream(
                "src\\com\\zxd\\basics\\look12\\StaticFile\\a.txt",
                true);

        // 只能写byte[]或者int类型的数据 ，写int类型的数据后会转换成ASCII表中对应的内容
        fos.write(65); // A

        // 关闭流
        fos.close();

        // 读数据
        // 方式一：一次读取一个字符
        FileInputStream fis = new FileInputStream("src\\com\\zxd\\basics\\look12\\StaticFile\\a.txt");
//        int ch;
//        while ((ch = fis.read()) != -1){
//            System.out.print((char)ch);
//        }
//        fis.close();

        // 方式二：一次读取一个字节数组
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
    }
}
