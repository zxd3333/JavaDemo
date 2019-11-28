package com.zxd.basics.j;

import java.util.HashSet;
import java.util.Set;

//Set集合的简单了解
//没有重复元素
//没有索引
//是一个接口
//学习Set主要还是看它的实现类:LinkedHashSet、HashSet、TreeSet
public class SetDemo {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        //添加元素
        //不会将重复的元素添加进去
        set.add("Hello");
        set.add("World");
        set.add("Hello");

        //遍历输出
        for (String s : set){
            System.out.println(s);
        }

        //返回一个包含所有set元素的数组
        Object[] array = set.toArray();
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
