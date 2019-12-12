package com.zxd.basics.look02;

// 运算符
public class OperatorDemo {

    public static void main(String[] args) {
        int a;
        int b;
        // 赋值运算符
        a = 10;
        b = 10;
        System.out.println("a = " + a +", b = " + b);

        System.out.println("==========================");

        // 算数运算符
        System.out.println("a = " + a +", b = " + b + ", a + b =" + (a + b));
        System.out.println("a = " + a +", b = " + b + ", a - b =" + (a - b));
        System.out.println("a = " + a +", b = " + b + ", a * b =" + (a * b));
        System.out.println("a = " + a +", b = " + b + ", a / b =" + (a / b));
        System.out.println("a = " + a +", b = " + b + ", a % b =" + (a % b));
        String c = "";
        System.out.println("字符串在后面：" + (a + b + c));  //20
        System.out.println("字符串在前面：" + (c + a + b));  //1010

        System.out.println("==========================");

        // 自增自减运算符
        int a1 = a++;
        System.out.println("a = " + a + ", a1 = " + a1);
        int a2 = a--;
        System.out.println("a = " + a + ", a2 = " + a2);
        int a3 = ++a;
        System.out.println("a = " + a + ", a3 = " + a3);
        int a4 = --a;
        System.out.println("a = " + a + ", a4 = " + a4);

        System.out.println("==========================");

        // 关系运算符
        System.out.println("a = " + a + ", b = " + b + ", a >  b 吗？ " + (a > b));
        System.out.println("a = " + a + ", b = " + b + ", a >= b 吗？ " + (a >= b));
        System.out.println("a = " + a + ", b = " + b + ", a == b 吗？ " + (a == b));
        System.out.println("a = " + a + ", b = " + b + ", a != b 吗？ " + (a != b));
        System.out.println("a = " + a + ", b = " + b + ", a <  b 吗？ " + (a < b));
        System.out.println("a = " + a + ", b = " + b + ", a <= b 吗？ " + (a <= b));

        System.out.println("==========================");

        // 逻辑运算符
        // 都真才真
        System.out.println((a > 100) & (a < 50));
        // 有真就真
        System.out.println((a > 100) | (a < 50));
        // 不同就真
        System.out.println((a > 100) ^ (a < 50));

        System.out.println("==========================");

        // 位运算符
        // a：0000 1010
        // b：0000 1010
        // 都为 1 才是 1
        System.out.println(a & b);
        // 有 1 就是 1
        System.out.println(a | b);
        // 不同就是 1
        System.out.println(a ^ b);
        //下面三个了解即可，不了解也无所谓
        // 按位取反：这个要看原码反码补码的关系才能明白
        System.out.println(~b);
        // 右移两位
        System.out.println(a>>2);
        // 左移两位
        System.out.println(a<<2);

        System.out.println("==========================");

        // 三目运算符
        System.out.println("a = " + a);
        System.out.println(a > 100? (a = 10) : (a = 100));
        System.out.println("a = " + a);
    }
}
