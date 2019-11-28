package com.zxd.basics.j;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

//LinkedList底层是双向链表
//链表结构的东西增加或者插入的速度快
//数组结构的东西因为有明确的索引，所以查询速度快
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        //添加元素
        linkedList.add("Hello");
        System.out.println(linkedList);
        //在集合的头部添加
        linkedList.addFirst("First");
        System.out.println(linkedList);
        //在集合的尾部添加
        linkedList.addLast("Last");
        System.out.println(linkedList);

        //获取头部元素，尾部元素
        System.out.println("头部元素：" + linkedList.getFirst() + ",尾部元素：" + linkedList.getLast());

        //获取指定位置的元素
        System.out.println("下标为0的元素为" + linkedList.get(0));

        //删除并返回指定位置的元素
        System.out.print("删除的元素为：" + linkedList.remove(0));

        //遍历集合
        System.out.println();
        for (String s :linkedList){
            System.out.print(s + " ");
        }

        //通过迭代器进行遍历
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }

        //通过ListIterator进行遍历
        ListIterator<String> ll = linkedList.listIterator();
        while (ll.hasNext()){
            if (ll.next().equals("Last")){
                ll.set("World");
            }
        }
        System.out.println(linkedList);
    }
}
