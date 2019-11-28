package com.zxd.basics.m;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

//Properties主要是读取配置文件
//它可以将数据保存到流中或从流中读取数据
//Map体系中的一个集合类
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        Properties p = new Properties();
        p.put(1,"Hello");
        p.put(2,"世界");

        Set<Object> set = p.keySet();
        for (Object key : set){
            Object value = p.get(key);
            System.out.println(key + ":" + value);
        }

        //特有方法
        Properties p1 = new Properties();
        p1.setProperty("1","hello");
        p1.setProperty("2","世界");
        System.out.println(p1);

        System.out.println(p1.getProperty("1"));

        Set<String> set1 = p1.stringPropertyNames();
        for (String key : set1){
            System.out.println(key + ":" + p1.getProperty(key));
        }

        //Properties和IO流的结合使用
        Properties p2 = new Properties();
        p2.setProperty("1","你好");
        p2.setProperty("2","world");
        FileWriter fw = new FileWriter("src\\com\\zxd\\basics\\m\\g.txt");
        p2.store(fw,null);
        fw.close();

        FileReader fr = new FileReader("src\\com\\zxd\\basics\\m\\g.txt");
        p2.load(fr);
        fr.close();
        System.out.println(p2);

        //案例：Properties从文件中读取数据
        //判断进行游戏的次数
        Properties p3 = new Properties();

        FileReader fileReader = new FileReader("src\\com\\zxd\\basics\\m\\h.txt");
        p.load(fileReader);
        fr.close();

        String s = p.getProperty("count");
        int i = Integer.parseInt(s);
        if (i < 3){
            GuessGame();
            i++;
            p3.setProperty("count",String.valueOf(i));
            FileWriter fileWriter = new FileWriter("src\\com\\zxd\\basics\\m\\h.txt");
            p3.store(fileWriter,null);
            fileWriter.close();
        }
        else {
            System.out.println("次数完了");
        }
    }

    public static void GuessGame(){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("欢迎来到猜数游戏，请输入一个1~100之间的数字");
        int randomNumber = r.nextInt(100) + 1;
        while(true){
            int guessNumber = sc.nextInt();
            if (guessNumber > randomNumber){
                System.out.println("你猜的太大了");
            }else if (guessNumber < randomNumber){
                System.out.println("你猜的太小了");
            }else {
                System.out.println("恭喜你猜对了");
                break;
            }
        }
    }
}
