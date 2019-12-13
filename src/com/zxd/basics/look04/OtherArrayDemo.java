package com.zxd.basics.look04;

// 稀疏数组
public class OtherArrayDemo {

    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        arr[1][2] = 1;
        arr[2][3] = 2;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("=====================================");

        // 二维数组转化为稀疏数组
        // 1.获取有效数值的个数
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <arr[i].length; j++){
                if (arr[i][j] != 0){
                    sum++;
                }
            }
        }
        // 2.根据有效数值创建稀疏数组
        // 创建一个sum+1行，3列的数组
        int[][] array = new int[sum+1][3];
        // 稀疏数组第一行的三个数据
        array[0][0] = 10;
        array[0][1] = 10;
        array[0][2] = sum;
        // 3.遍历数组，将非零的数字存放到稀疏数组
        // 定义一个数字记录稀疏数组的行数
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <arr[i].length; j++){
                if (arr[i][j] != 0){
                    count++;
                    array[count][0] = i;
                    array[count][1] = j;
                    array[count][2] = arr[i][j];
                }
            }
        }
        // 4.输出稀疏数组
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i][0] + "\t"
                             + array[i][1] + "\t"
                             + array[i][2] + "\t");
        }

        System.out.println("=====================================");

        // 稀疏数组转换成普通的二维数组
        // 1.定义二维数组
        int[][] a = new int[array[0][0]][array[0][1]];
        // 2.遍历稀疏数组，为二维数组赋值
        for (int i = 1; i < array.length; i++){
            a[array[i][0]][array[i][1]] = array[i][2];
        }
        // 3.打印二维数组
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
