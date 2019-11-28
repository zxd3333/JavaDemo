package com.zxd.basics.b;

//运算符
public class OperatorDemo {

    public static void main(String[] args) {
        int a;
        int b;
        //赋值运算符
        a = 10;
        b = 10;
        System.out.println("a = " + a +", b = " + b);

        System.out.println("==========================");

        //算数运算符
        System.out.println("a = " + a +", b = " + b + ", a + b =" + (a + b));
        System.out.println("a = " + a +", b = " + b + ", a - b =" + (a - b));
        System.out.println("a = " + a +", b = " + b + ", a * b =" + (a * b));
        System.out.println("a = " + a +", b = " + b + ", a / b =" + (a / b));
        System.out.println("a = " + a +", b = " + b + ", a % b =" + (a % b));

        System.out.println("==========================");

        //自增自减运算符
        int a1 = a++;
        System.out.println("a = " + a + ", a1 = " + a1);
        int a2 = a--;
        System.out.println("a = " + a + ", a2 = " + a2);
        int a3 = ++a;
        System.out.println("a = " + a + ", a3 = " + a3);
        int a4 = --a;
        System.out.println("a = " + a + ", a4 = " + a4);

        System.out.println("==========================");

        //关系运算符
        System.out.println("a = " + a + ", b = " + b + ", a >  b 吗？ " + (a > b));
        System.out.println("a = " + a + ", b = " + b + ", a >= b 吗？ " + (a >= b));
        System.out.println("a = " + a + ", b = " + b + ", a == b 吗？ " + (a == b));
        System.out.println("a = " + a + ", b = " + b + ", a != b 吗？ " + (a != b));
        System.out.println("a = " + a + ", b = " + b + ", a <  b 吗？ " + (a < b));
        System.out.println("a = " + a + ", b = " + b + ", a <= b 吗？ " + (a <= b));

        System.out.println("==========================");

        //逻辑运算符
        System.out.println((a > 100) & (a < 50));
        System.out.println((a > 100) | (a < 50));
        System.out.println((a > 100) ^ (a < 50));
        System.out.println((a > 100) && (a < 50));
        System.out.println((a > 100) || (a < 50));

        System.out.println("==========================");

        //三目运算符
        System.out.println("a = " + a);
        System.out.println(a > 100? (a = 10) : (a = 100));
        System.out.println("a = " + a);
    }
}
