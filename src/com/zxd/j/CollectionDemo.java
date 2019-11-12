package com.zxd.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Collection集合的使用
//Collection是一个接口
//Collection是无序的
public class CollectionDemo {

    public static void main(String[] args) {
        // 因为接口不能实例化
        // 这里创建接口实现类的对象
        Collection<String> collection = new ArrayList<String>();

        //首先判断集合是否为空
        if (collection.isEmpty()){
            //如果为空，执行添加操作
            //子类重写了父类中的方法，那么调用的就是子类中重写的方法
            collection.add("Hello");
            collection.add("World");
            collection.add("Java");
            collection.add("Java");

            //ArrayList的父类的父类重写了toString方法，所以这里不会输出地址值
            System.out.println("添加某些元素之后的集合：" + collection);
        }
        //判断集合的长度
        if (collection.size() < 1){
            //如果长度小于1，说明集合为空
        } else {
            //如果集合不为空
            //查看是否有某个元素
            if (collection.contains("Java")){
                //如果有,可以进行删除
                //注意，如果有重复的元素，只会删掉第一个出现的
                collection.remove("Java");
            }else {
                System.out.println("集合中没有\"Java\"这个元素");
            }
            System.out.println("移除某些元素之后的集合：" + collection);
        }

        //遍历集合
        //集合不是数组，没有指定的索引，于是不能通过for循环来遍历
        //遍历的方法很多，挑了两种
        //方法一：foreach
        for (String str : collection) {
            System.out.println(str);
        }
        //方式二：通过迭代器Iterator接口
        //迭代器是集合专用的遍历方式，但是它不能修改集合中的元素
        //首先获取迭代器，通过iterator()返回集合元素的迭代器
        Iterator i = collection.iterator();
        //通过循环，hasNext(),判断是否有下一个元素
        while (i.hasNext()){
            //next()，返回集合下一个元素
            System.out.println(i.next());
        }

        //清空集合
        collection.clear();
        System.out.println("清空元素之后的集合：" + collection);
    }
}
