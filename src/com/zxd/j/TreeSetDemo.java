package com.zxd.j;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//TreeSet是一个有序的集合类
//它里面的元素是有顺序的，主要作用是提供有序的Set集合
//没有索引
//不包含重复元素
//基于TreeMap
//排序方式：自然排序（Comparable）和比较器排序（Comparator）
public class TreeSetDemo {

    public static void main(String[] args) {
        //自然排序：无参构造方法，让元素所属的类实现Comparable<?>接口，重写里面的compareTo方法
        TreeSet<Person> treeSet = new TreeSet<>();

        Person p1 = new Person("a",10);
        Person p2 = new Person("b",20);
        Person p3 = new Person("c",30);
        Person p4 = new Person("d",10);

        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);

        for (Person p : treeSet){
            System.out.println(p);
        }
        System.out.println("=======================");

        //比较器排序：带参构造方法
        //通过匿名内部类的方式实现Comparator接口并重写其方法
        TreeSet<Person> ts = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int num = o1.getAge() - o2.getAge();
                int num2 = num == 0 ? o1.getName().compareTo(o2.getName()) : num;
                return num2;
            }
        });

        Person o1 = new Person("a",10);
        Person o2 = new Person("b",20);
        Person o3 = new Person("c",10);
        Person o4 = new Person("d",10);

        ts.add(o1);
        ts.add(o2);
        ts.add(o3);
        ts.add(o4);

        Iterator i = ts.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

    }
}
