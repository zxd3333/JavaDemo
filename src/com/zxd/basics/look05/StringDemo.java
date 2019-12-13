package com.zxd.basics.look05;

// String、StringBuilder、StringBuffer的使用
public class StringDemo {

    public static void main(String[] args) {
        // Java会在常量池中创建一个字符串"Hi"，s会指向这个字符串
        String s = "Hi";
        // 创建一个新的变量t，将s地址赋给t
        String t = s;
        System.out.println(t);

        // 重新在常量池中创建一个字符串"Hello",然后把s指向这个字符串
        s = "Hello";
        // 在常量池中创建一个字符串"World",并且会创建一个新的字符串"HelloWorld"，然后把s指向这个字符串
        s += "World";
        System.out.println("拼接后的字符串：" + s);

        // String和字符数组的转换
        // String -> char[] ch
        char[] ch = s.toCharArray();
        System.out.print("字符串转换成字符数组的内容：");
        for (int i = 0; i < ch.length; i++){
            if (i == ch.length - 1){
                System.out.println(ch[i]);
            }else {
                System.out.print(ch[i] + ",");
            }
        }
        // char[] ch -> String
        char[] ch1 = new char[]{'H','e','l','l','o',',','W','o','r','l','d'};
        String str = String.valueOf(ch1);
        System.out.println("字符数组转换成字符串的内容：" + str);

        System.out.println("==========================");

        // StringBuilder的使用
        StringBuilder sb = new StringBuilder();
        sb.append("Hello,").append("World");
        System.out.println("StringBuilder的内容：" + sb);
        // reverse()方法：反转拼接后的字符
        sb.reverse();
        System.out.println("反转后的内容：" + sb);

        // String和StringBuilder的互相转换
        // StringBuilder -> String
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Hello").append(",World");
        String s1 = sb1.toString();
        System.out.println("StringBuilder转换成String的内容：" + s1);
        // String -> StringBuilder
        String s2 = "HelloWorld";
        StringBuilder sb2 = new StringBuilder(s2);
        System.out.println("String转换成StringBuilder的内容：" + sb2);

        // StringBuffer的使用
        // StringBuffer的功能与StringBuilder类似，只是它们使用的场景略有不同
        // 此处不再累述
    }
}
