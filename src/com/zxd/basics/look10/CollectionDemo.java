package com.zxd.basics.look10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// 单列集合的祖宗：Collection
public class CollectionDemo {

    public static void main(String[] args) {

        // Collection集合是一个接口，创建它需要使用多态
        Collection<String> c = new ArrayList<String>();

        // 了解它的一些方法
        // 首先判断集合是否为空
        if (c.isEmpty()){
            // 如果为空，执行添加操作
            // 子类重写了父类中的方法，那么实际上就是调用ArrayList<E>中重写的add()方法
            c.add("I");
            c.add("say");
            c.add("Hello");
            c.add("World");
            // 查看源码发现ArrayList的父类的父类重写了toString方法，所以这里相当于调用父类的父类中的方法，故而不会输出地址值
            System.out.println("添加某些元素之后的集合：" + c);
        }
        // 判断集合的长度
        if (c.size() < 1){
            // 如果长度小于1，说明集合为空
        } else {
            // 如果集合不为空
            // 查看是否有某个元素
            if (c.contains("World")){
                // 如果有,可以进行删除
                // 注意，如果有重复的元素，只会删掉第一个出现的
                c.remove("World");
            } else {
                System.out.println("集合中没有\"World\"这个元素");
            }
            System.out.println("移除某些元素之后的集合：" + c);
        }

        // 遍历集合
        // 集合不是数组，没有指定的索引，于是不能通过for循环来遍历
        // 遍历的方法很多，挑了两种
        // 方法一：foreach
        for (String str : c) {
            System.out.println(str);
        }
        // 方式二：通过迭代器Iterator接口
        // 迭代器是集合专用的遍历方式，但是它不能修改集合中的元素
        // 首先获取迭代器，通过iterator()方法返回集合元素的迭代器
        Iterator i = c.iterator();
        // hasNext()判断是否有下一个元素
        while (i.hasNext()){
            // next()，返回集合下一个元素
            System.out.println(i.next());
        }

        // 清空集合
        c.clear();
        System.out.println("清空元素之后的集合：" + c);
    }
}
