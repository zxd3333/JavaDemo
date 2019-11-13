package com.zxd.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

//HashMap的简单案例
public class HashMapDemo {

    public static void main(String[] args) {
        //HashMap实现斗地主发牌
        HashMap<Integer,String> map = new HashMap<>();

        //创建牌的花色和数组的数组
        String[] s1 = {"♠","♥","♣","♦"};
        String[] s2 = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        //创建牌 1~54 的顺序的数组结合
        ArrayList<Integer> arrayList = new ArrayList<>();
        //记录牌的顺序，并将牌按照顺序加入到HashMap中
        int index = 0;

        //将牌添加到HashMap中
        for(int i = 0; i < s1.length; i++){
            for (int j = 0; j < s2.length; j++){
                //将所有牌加入集合中，index记录每个牌对应的Key
                map.put(index,s1[i] + s2[j]);
                arrayList.add(index);
                index++;
            }
        }

        //添加大王小王
        map.put(index,"BigKing");
        arrayList.add(index);
        index++;
        map.put(index,"SmallKing");
        arrayList.add(index);

        //此方法是使得ArrayList的顺序发生变化，模拟洗牌
        Collections.shuffle(arrayList);

        //通过TreeSet存储不同人物的牌的序列，TreeSet默认会排序
        //这里使用ArrayList也可以，只不过最后输出的没有排序罢了
        //三个人分别17张，留下来三张给地主，所以创建四个TreeSet
        TreeSet<Integer> t1 = new TreeSet<>();
        TreeSet<Integer> t2 = new TreeSet<>();
        TreeSet<Integer> t3 = new TreeSet<>();
        TreeSet<Integer> t4 = new TreeSet<>();

        for (int i = 0; i < arrayList.size(); i++){
            //先确定地主的三张牌
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
        //发完牌了，通过循环给每个TreeSet中添加了一些数字
        //之后根据数字遍历TreeSet获得每个数字，
        //再根据数字从HashMap中输出每个数字对应的牌型和内容
        System.out.print("地主：");
        for (int i : t1){
            System.out.print(map.get(i) + " ");
        }
        for (int i : t2){
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
        System.out.print("农民1：");
        for (int i : t3){
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
        System.out.print("农民2：");
        for (int i : t4){
            System.out.print(map.get(i) + " ");
        }
    }

}
