package com.zxd.j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//List集合的使用
//List是一个接口
//List集合是有序的，它有索引，允许有重复的元素
public class ListDemo {

    public static void main(String[] args) {
        //List接口继承了Collection接口，所以可以实现Collection接口的所有方法
        //List也有自己独有的方法
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("Java");

        //List相比于Collection，独有的add()
        //add(指定位置，要插入的元素)，指定位置的值不能小于0，不能大于集合长度
        list.add(list.size() - 1,"INSERT");
        System.out.println("集合中的元素：" + list);  // Hello,World,INSERT,Java
        //删除指定位置的元素，并将删除的元素返回
        System.out.println(list.remove(2));  //INSERT
        //修改指定位置的元素，并将修改前的元素返回
        System.out.println(list.set(0,"Hi"));    //Hello
        //获取指定位置的元素
        System.out.println(list.get(2));  //Java

        //遍历输出
        //方式一：foreach
        System.out.print("foreach遍历：");
        for (String str : list) {
            System.out.print(str + " ");
        }

        //方式二：for
        System.out.println();
        System.out.print("for遍历：");
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        //方式三：Iterator迭代器
        System.out.println();
        System.out.print("Iterator遍历：");
        Iterator i = list.iterator();
        while (i.hasNext()){
            System.out.print(i.next() + " ");
        }

        //方式四，正常情况下，遍历的时候进行修改操作，会产生并发修改异常
        //为了解决这个异常，提出了ListIterator
        System.out.println();
        System.out.print("遍历ListIterator并修改元素后的List集合：");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            //如果有Java这个属性
            if (listIterator.next().equals("Java")){
//                //可以把它改成Android
//                listIterator.set("Android");
                //可以他后面插入一个元素
                //注意这里不是直接添加到列表集合当中
                //而是运用了列表迭代器的添加方法
                listIterator.add("Ha");
            }
        }

        //输出修改后的列表
        System.out.println(list);
    }
}
