package com.zxd.basics.look03;

// if...else语句
public class IfDemo {
    public static void main(String[] args) {
        int a = 50;
        String str;
        if (a > 50){
            str = "50 < a < 100";
        }else if (a > 0){
            str = "0 < a <= 50";
        }else {
            str = "a <= 0";
        }
        System.out.println(str);
    }
}
