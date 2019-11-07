package com.zxd.c;

//switch
public class SwitchDemo {

    public static void main(String[] args) {
        int a = 5;
        switch (a){
            case 1:
                System.out.println("今天周一");
                //不写break,则会执行匹配到的case之后所有的case后的语句，直到遇到break
                break;
            case 2:
                System.out.println("今天周二");
                break;
            case 3:
                System.out.println("今天周三");
                break;
            case 4:
                System.out.println("今天周四");
                break;
            case 5:
                System.out.println("今天周五");
                break;
            case 6:
                System.out.println("今天周六");
                break;
            case 7:
                System.out.println("今天周日");
                break;
            //如果所有case语句都不符合，那么执行default语句
            default:
                System.out.println("数字不在1~7之间");
                break;
        }
    }
}
