package com.zxd.basics.look10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

// LinkedList集合
// LinkedList是一个类，它实现了List接口，所以它也是有序的，有索引的，元素可以重复的
// 但是，但是，但是它的索引是隐式的，而ArrayList的下标是显示的
// 要查找某一个位置的数据时，LinkedList需要从头开始数，而ArrayList直接可以取到某个位置的数据
// LinkedList底层双向链表，增删数据时只需要改变结点的指向即可
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        // 添加元素
        linkedList.add("Hello");
        System.out.println(linkedList);
        // 在集合的头部添加
        linkedList.addFirst("First");
        System.out.println(linkedList);
        // 在集合的尾部添加
        linkedList.addLast("Last");
        System.out.println(linkedList);

        // 获取头部元素，尾部元素
        System.out.println("头部元素：" + linkedList.getFirst() + "尾部元素：" + linkedList.getLast());

        // 获取指定位置的元素
        System.out.println("下标为0的元素为" + linkedList.get(0));

        // 删除并返回指定位置的元素
        System.out.print("删除的元素为：" + linkedList.remove(0));

        // 遍历集合
        System.out.println();
        for (String s :linkedList){
            System.out.print(s + " ");
        }
        System.out.println();

        // 通过迭代器进行遍历
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 通过ListIterator进行遍历
        ListIterator<String> li = linkedList.listIterator();
        while (li.hasNext()){
            if (li.next().equals("Last")){
                li.set("World");
            }
        }
        System.out.println(linkedList);
    }
}
