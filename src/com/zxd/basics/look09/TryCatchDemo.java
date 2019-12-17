package com.zxd.basics.look09;

// 异常
public class TryCatchDemo {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try{
            int c = a/b;
            System.out.println(c);
        }catch (ArithmeticException e){
            // 返回异常的描述信息
            System.out.println(e.getMessage());

            // 返回异常的类型和描述信息
            System.out.println(e.toString());

            // 在控制台打印异常对象封装的异常信息
            e.printStackTrace();

            // 自定义输出内容
            System.out.println("第二个数字不能为0");
        }finally {
            System.out.println("finally");
        }
    }
}
