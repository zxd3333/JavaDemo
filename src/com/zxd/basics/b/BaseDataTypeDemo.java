package com.zxd.basics.b;

//基本数据类型
public class BaseDataTypeDemo {

    public static void main(String[] args) {
        //整型
        byte a = 10;
        short a2 = 10;
        int a3 = 10;
        long a4 = 10L;

        //浮点型
        float b1 = 3.14F;
        double b2 = 3.1415;

        //字符型
        char c = 'a';

        //布尔型
        boolean flag = true;

        //自动类型转换
        //小 -> 大
        short x1 = 100;
        int x2 = x1;
        double x3 = x2;
        System.out.println("short转int再转double: " + x1 + " -> " + x2 + " -> " + x3);

        char v1 = 'A';
        int v2 = v1;
        double v3 = v2;
        System.out.println("char转int再转double: " + v1 + " -> " + v2 + " -> " + v3);

        //强制类型转换
        //大 -> 小
        double y1 = 3.1415;
        int y2 = (int) y1;
        short y3 = (short) y2;
        System.out.println("double转int再转short: " + y1 + " -> " + y2 + " -> " + y3);

        double z1 = 78.356;
        int z2 = (int) z1;
        char z3 = (char) z2;
        System.out.println("double转int再转char: " + z1 + " -> " + z2 + " -> " + z3);

        // == 和 .equals() 的使用
        // == 比较基本数据类型时，比较的数值是否一样
        // == 比较两个对象时，比较的是两个对象的地址值
        int num1 = 123;
        int num2 = 123;
        System.out.println(num1 == num2);
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello");
        //String重写了.equals()方法，如果两个对象地址值一样，返回true
        //如果地址值不一样，比较两个对象的值是否一样，一样就返回true
        //==在对象中比较的是地址值，str1和str2都指向了常量池中的"hello"，所以地址值一样
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str3 == str4);
    }
}
