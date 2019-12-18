package com.zxd.basics.look10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

// HashMap实现斗地主发牌
public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<Integer,String> hashMap = new HashMap<>();

        // 创建牌的花色和数字的数组，这两个数组组合起来就是一副牌
        String[] s1 = {"♠","♥","♣","♦"};
        String[] s2 = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        // index 是 HashMap集合中的 key，它跟牌型一一对应
        // 将 index 的值存入 ArrayList 中
        int index = 0;

        // 创建ArrayList集合记录牌对应的顺序
        ArrayList<Integer> arrayList = new ArrayList<>();

        // 遍历数组创建扑克牌
        // 然后将牌添加到HashMap集合中
        // 同时通过index记录每个牌的位置，将位置存入ArrayList中
        for (int i = 0; i < s1.length; i++){
            for (int j = 0; j < s2.length; j++){
                hashMap.put(index,s1[i]+s2[j]);
                arrayList.add(index);
                index++;
            }
        }
        // 添加大王小王
        hashMap.put(index,"大");
        arrayList.add(index);
        index++;
        hashMap.put(index,"小");
        arrayList.add(index);

        // 此方法可以使ArrayList的顺序发生变化，模拟洗牌
        Collections.shuffle(arrayList);

        // 通过TreeSet存储不同人物的牌的序列，TreeSet默认会排序
        // 这里使用ArrayList也可以，只不过最后输出的没有排序罢了
        // 三个人分别17张，留下来三张给地主，所以创建四个TreeSet
        TreeSet<Integer> t1 = new TreeSet<>();
        TreeSet<Integer> t2 = new TreeSet<>();
        TreeSet<Integer> t3 = new TreeSet<>();
        TreeSet<Integer> t4 = new TreeSet<>();

        for (int i = 0; i < arrayList.size(); i++){
            // 先确定地主的三张牌
            if (i > arrayList.size() - 3){
                t1.add(arrayList.get(i));
            }else if (i % 3 == 1){
                t2.add(arrayList.get(i));
            }else if (i % 3 == 2){
                t3.add(arrayList.get(i));
            }else {
                t4.add(arrayList.get(i));
            }
        }

        // 遍历每个TreeSet集合获得index，再根据 index 从 HashMap 中输出牌型
        System.out.print("地主： ");
        for (int i : t1){
            System.out.print(hashMap.get(i) + " ");
        }
        for (int i : t2){
            System.out.print(hashMap.get(i) + " ");
        }
        System.out.println();
        System.out.print("农民1：");
        for (int i : t3){
            System.out.print(hashMap.get(i) + " ");
        }
        System.out.println();
        System.out.print("农民2：");
        for (int i : t4){
            System.out.print(hashMap.get(i) + " ");
        }
    }

}
