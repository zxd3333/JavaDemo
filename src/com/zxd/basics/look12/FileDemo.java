package com.zxd.basics.look12;

import java.io.File;
import java.io.IOException;

// File类
// 它是文件和目录的路径名的抽象表示形式
// 它的实例是不可变的
// 它只是指向了一个路径，并不是创建一个文件
// 即使我们指向了一个不存在的路径，代码也不会报错的，但是运行就报错了哈哈哈哈
public class FileDemo {

    public static void main(String[] args) throws IOException {

        // 将指定路径名转化成一个File对象
        // 方式一
        File f1 = new File("src\\com\\zxd\\basics\\look12\\StaticFile\\a.txt");

        // 方式二
        File f2 = new File("src\\com\\zxd\\basics","StaticFile\\look12\\a.txt");

        // 方式三
        File f3 = new File("src\\com\\zxd\\basics");
        File f4 = new File(f3,"StaticFile\\look12\\a.txt");

        // 返回绝对路径名
        System.out.println(f1.getAbsolutePath());

        // 创建一个目录
        // mkdir() 是创建一个目录，目录不存在就创建并返回true，目录存在就返回false
        // mkdirs() 可以创建多层目录
        File file = new File("src\\com\\zxd\\basics\\look12","\\StaticFile");
        System.out.println(file.mkdir());

        // createNewFile() 是创建一个文件，文件不存在就创建并返回true，文件存在就返回false
        File file2 = new File("src\\com\\zxd\\basics\\look12","\\StaticFile\\a.txt");
        System.out.println(file2.createNewFile());

        // 判断是否是目录
        System.out.println(file2.isDirectory());

        // 判断是否是文件
        System.out.println(file2.isFile());
    }
}
