package com.zxd.basics.look10;

import java.util.HashSet;
import java.util.Iterator;

// HashSet是一个集合类
// 不保证数据的存入和读取的顺序一致
// 没有索引，故而不能使用普通for循环
// 底层是哈希表，所以不包含重复元素
// 内部使用HashMap存储数据，数据存储在HashMap的key当中，value是同一个默认值
public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        // 添加元素
        if (hashSet.isEmpty()) {
            hashSet.add("Hello");
            hashSet.add("World");
            hashSet.add("Hello");
        }
        System.out.println(hashSet);

        System.out.println(hashSet.size());
        System.out.println(hashSet.contains("Java"));
        System.out.println(hashSet.remove("World"));

        for (String s : hashSet) {
            System.out.println(s);
        }

        Iterator i = hashSet.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        // 集合中要使用引用类型数据，不能使用基本数据类型
        HashSet<Character> h = new HashSet<>();
        // 返回字符串中第一个重复的元素
        // 利用HashSet的add方法和HashSet元素的不可重复性
        String s = "abcd11ddr122";
        char[] ch = s.toCharArray();
        for (int a = 0; a < ch.length; a++){
            boolean v = h.add(ch[a]);
            if (!v){
                System.out.println(ch[a]);
                break;
            }
        }

    }
}
