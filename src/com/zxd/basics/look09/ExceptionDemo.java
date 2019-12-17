package com.zxd.basics.look09;

import java.util.InputMismatchException;
import java.util.Scanner;

// 异常
public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("演示Exception");
        Scanner input = new Scanner(System.in);

        try{
            System.out.print("输入第一个数字:");
            int a = input.nextInt();
            System.out.print("输入第二个数字:");
            int b = input.nextInt();
            int result = a / b;
            System.out.println("结果是：" + result);
        } catch (InputMismatchException e2){
            System.out.println("输入数值有误");
        } catch (ArithmeticException e1){
            System.out.println("数字不能为0");
        } catch (Exception e){
            System.out.println("其他我们可能遗漏的错误");
        } finally {
            System.out.println("finally常用于编写释放资源的代码，它总会被执行，除非程序退出或者线程中断");
        }
        System.out.println("这是try...catch...finally语句之后的内容");
    }
}
