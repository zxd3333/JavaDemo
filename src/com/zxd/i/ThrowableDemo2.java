package com.zxd.i;

import java.util.InputMismatchException;
import java.util.Scanner;

//一个try可以有多个catch
public class ThrowableDemo2 {

    public static void main(String[] args) {
        System.out.println("除法演示Exception.");
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("输入第一个数字");
            int num1 = input.nextInt();
            System.out.println("输入第二个数字");
            int num2 = input.nextInt();
            int result = num1 / num2;
            System.out.println("结果是：" +result);
        }catch (InputMismatchException e1){
            System.out.println("输入数值有误");
        }catch (ArithmeticException e2){
            System.out.println("数字不能为0");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("其他错误");
        }
        System.out.println("这是try...catch语句之后的内容");
    }
}
