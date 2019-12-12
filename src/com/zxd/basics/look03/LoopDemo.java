package com.zxd.basics.look03;

// 三种循环的使用
// continue、break的使用
public class LoopDemo {

    public static void main(String[] args) {
        // while循环
        int a = 1;
        while(a < 5){
            System.out.print(a + " ");
            a++;
        }

        System.out.println();
        System.out.println("=======");

        // do...while
        // do...while循环语句至少会执行一次
        int b = 1;
        do {
            System.out.print(b + " ");
            b++;
        }while (b < 5);

        System.out.println();
        System.out.println("=======");

        // for
        for (int i = 1; i < 5; i++){
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("=======");

        // break
        for (int i = 1; i < 5; i++){
            if (i == 2){
                // break，跳出循环
                break;
            }
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("=======");

        // continue
        for (int i = 1; i < 5; i++){
            if (i == 2){
                // continue，跳出本次循环，开始下一次循环
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
