package com.zxd.basics.look04;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

// 数组
public class ArrayDemo {

    public static void main(String[] args) {
        // 一维数组
        // 静态初始化
        int[] arr1 = new int[]{100,200,300};
        // 静态初始化简化写法
        // int[] arr = {100,200,300};

        // 输出数组名默认是数组在内存中的地址值
        System.out.println(arr1);
        //遍历数组元素方式一
        for (int i = 0; i< arr1.length; i++){
            System.out.println(arr1[i]);
        }
        // 遍历数组方式二
        for(int i : arr1){
            System.out.println(i);
        }

        // 动态初始化
        String[] arr2 = new String[3];
        // 输出数组名默认是数组在内存中的地址值
        System.out.println(arr2);
        // 遍历数组

        /*
           引用类型默认为 null
           整型默认为 0
           浮点数默认为 0.0
           字符类型默认为 空字符(就是什么都不显示,地址和数组元素都为空)
           布尔类型默认为 false
        */
        for (int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }

        // 二维数组静态初始化
        int[][] arr3 = new int[][]{{1,3,5,7,9},{2,4,6,8,10}};
        // 静态初始化简写
        // int[][] arr = {{1,3,5,7,9},{2,4,6,8,10}};
        // 输出数组名默认是数组在内存中的地址值
        System.out.println(arr3);
        // 遍历数组元素
        // 先遍历行
        for (int i = 0; i< arr3.length; i++){
            // 再遍历列
            for (int j = 0; j < arr3[i].length; j++){
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }

        // 动态初始化
        int[][] arr4 = new int[7][7];
        // 输出一个十字星阵
        for (int i = 0; i < arr4.length; i++){
            for (int j = 0; j < arr4[i].length; j++){
                if (j == 3 || i == 3){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        //Arrays的使用
        int[] array = {1,5,6,3,2,0,6,3,5,8,9,2,0,12,23};
        //打印数组元素
        System.out.println(Arrays.toString(array));
        //对数组进行排序
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        //对数组进行填充
        Arrays.fill(array,3,8,0);
        System.out.println(Arrays.toString(array));
    }
}
