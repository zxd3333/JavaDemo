package com.zxd.j;

import java.util.HashSet;
import java.util.LinkedHashSet;

//LinkedHashSet的底层结构是哈希表和链表
//因为链表的缘故，它里面元素的存入和取出的顺序一致
//它实现了Set接口，所以也没有索引
//因为哈希表，使得它不包含重复元素
//它的父类是HashSet，它主要的优化就是实现了元素的有序输入输出
public class LinkedHashSetDemo {

    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Hello");
        linkedHashSet.add("World");
        linkedHashSet.add("Java");

        for (String s : linkedHashSet){
            System.out.println(s);
        }

        System.out.println("====================");

        //对比两者输出
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHash = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++){
            hashSet.add("A" + i);
            linkedHash.add("A" + i);
        }

        System.out.println(hashSet);
        System.out.println(linkedHash);

    }
}
