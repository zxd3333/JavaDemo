package com.zxd.m;

import java.io.File;
import java.io.IOException;

//File类：文件和目录的路径名的抽象表示形式
//        它的实例是不可变的
//        它只是指向了一个路径，并不是创建一个文件
//        即使我们指向了一个不存在的路径，代码也不会报错的，但是运行就报错了哈哈哈哈
public class FileDemo {

    public static void main(String[] args) throws IOException {
        //将指定路径名转化成一个File对象
        //有三种方式，方式二和方式三其实就是把第一种拆分了
        //方式一：文件的路径创建
        File f = new File("src\\com\\zxd\\m\\a.txt");
        //方式二：父路径和文件名创建
        File f1 = new File("src\\com\\zxd\\m\\a","a.txt");
        //方式三：根据指定的父路径对象和文件路径创建
        File f3 = new File("src\\com");
        File f4 = new File(f3,"zxd\\m\\a.txt");

        //返回f的绝对路径名，返回值是一个字符串
        System.out.println(f1.getAbsolutePath());

        //创建文件夹
        //mkdir()创建一个文件夹,A不存在，所以会创建A，并返回true
        //mkdirs()可以创建多个文件夹
        File f5 = new File("src\\com\\zxd\\m\\A");
        System.out.println(f5.mkdir());
        System.out.println(f5.getAbsolutePath());

        //创建文件夹
        //createNewFile()如果文件不存在，就创建并返回true
        File f6 = new File("src\\com\\zxd\\m\\A\\b.txt");
        System.out.println(f6.createNewFile());

        System.out.println(f6.isDirectory());
    }
}
