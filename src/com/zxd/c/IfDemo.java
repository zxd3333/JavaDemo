package com.zxd.c;

//if...else
public class IfDemo {
    public static void main(String[] args) {
        int a = 50;
        String str;
        if (a > 50){
            str = "50 < a < ?";
        }else if (a > 0){
            str = "0 < a <= 50";
        }else {
            str = "? < a <= 0";
        }
        System.out.println(str);
    }
}
