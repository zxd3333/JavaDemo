package com.zxd.basics.e;

import java.util.Random;
import java.util.Scanner;

//Random类的初步使用
public class RandomDemo {

    public static void main(String[] args) {
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
