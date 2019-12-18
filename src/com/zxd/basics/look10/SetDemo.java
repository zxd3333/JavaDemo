package com.zxd.basics.look10;

import java.util.HashSet;
import java.util.Set;


// Set集合
// Set集合是一个接口，它是无序的，没有索引，不允许重复元素
public class SetDemo {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        if (set.isEmpty()) {
            // 添加元素
            set.add("Hello");
            set.add("World");
            set.add("Java");
            set.add("Java");
        }

        // 查看set集合中是否包含"Hello"字符串，如果有，移除它
        if (set.contains("Hello")){
            set.remove("Hello");
        }

        // 遍历集合
        for (String s : set){
            System.out.println(s);
        }

        System.out.println("===");

        // 返回一个包含所有set元素的数组
        Object[] array = set.toArray();
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
