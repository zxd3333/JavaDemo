package com.zxd.basics.look04;

import java.util.Arrays;

// 几种排序
public class SortDemo {

    public static void main(String[] args) {
        int[] array = {1,2,5,6,4,8,3,7,9,0};
        System.out.println("排序前：" + Arrays.toString(array));
        // bubbleSort(array);
        // selectionSort(array);
        // insertionSort(array);
        quickSort(array,0,array.length-1);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    // 冒泡排序，每轮找出一个最大的放在最后面
    public static void bubbleSort(int[] arr){
        // 外层循环是要比较的轮数，每轮会找到一个最大的放在最后
        for (int i = 0; i < arr.length-1; i++){
            // 内层循环确定每次的最大值，如果arr[0] > arr[1]，就交换它们，以此类推
            // 每当确定一个最大值，就可以少比较一次
            for (int j = 0; j < arr.length-1-i; j++){
                if (arr[j] > arr[j+1]){
                    arr[j+1] = arr[j] + arr[j+1];
                    arr[j] = arr[j+1] - arr[j];
                    arr[j+1] = arr[j+1] - arr[j];
                }
            }
        }
    }

    // 选择排序，每轮找到最小的数字放在最前面
    public static void selectionSort(int[] arr){
        // 外层循环是要比较的轮数，每轮会找到一个最小的放在前面
        for (int i = 0; i < arr.length-1; i++){
            // 内层循环是拿第i个数据与后面所有数据依次比较，如果比后面的数字小就交换位置
            // 每当确定一个最小值，就可以少比较一次
            for (int j = i; j < arr.length-1; j++){
                if (arr[i] > arr[j+1]){
                    arr[j+1] = arr[i] + arr[j+1];
                    arr[i] = arr[j+1] - arr[i];
                    arr[j+1] = arr[j+1] - arr[i];
                }
            }
        }
    }

    // 插入排序，每轮都对前面的数据进行排序
    public static void insertionSort(int[] arr){
        // 外层循环是要比较的轮数，每轮对前i+1个数字进行排序
        for (int i = 0; i < arr.length-1; i++){
            // 每次进入内层循环之前，新增数字之前的数字都是排好序的
            for (int j = i+1; j > 0; j--){
                if (arr[j-1] > arr[j]){
                    arr[j] = arr[j-1] + arr[j];
                    arr[j-1] = arr[j] - arr[j-1];
                    arr[j] = arr[j] - arr[j-1];
                }
            }
        }
    }

    // 快速排序，指定基准值，基准值左边数字都比基准值小，右边都比基准值大
    // 然后通过递归进行排序
    public static void quickSort(int[] arr,int start,int end){

        //如果(0 >= arr.length-1)，表示数组有一个数据或者没有数据
        if (start >= end){
            return;
        }
        // 指定一个基准值key，一个起始位置i，一个末位位置j
        int key = arr[start];
        int i = start;
        int j = end;

        // 如果起始位置 < 末位位置，说明数组有元素
        while (i < j){
            // 数组中从右往左找，找到一个比key小的数字
            while ((i < j)&&(arr[j] >= key)){
                j--;
            }
            // 数组中从左往右找，找到一个比key大的数字
            while ((i < j)&&(arr[i] <= key)){
                i++;
            }
            // 交换上面找到的数字
            if (i < j){
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }

        // 上面的步骤完毕之后，i 和 j 的值就会相等，我们交换key的值和i的值
        // 交换完毕之后，key左边的值都比key小，key右边的数值都比key大
        arr[start] = arr[i];
        arr[i] = key;

        // 通过递归，将i左侧和右侧分别当成数组在进行排序
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
    }
}
