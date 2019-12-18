package com.zxd.basics.look10;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Map<K,V>是一个接口
// 键值对一一对应
// 不能包含重复的键
public class MapDemo {

    public static void main(String[] args) {

        // 多态创建map对象
        // 这里HashMap是无序的，LinkedHashMap是有序的，TreeMap按照key进行排列
        // 这里的有序无序是根据插入的顺序而定
        Map<Integer,String> map = new HashMap<>();

        // 添加元素
        map.put(10,"a");
        map.put(20,"b");
        map.put(30,"a");

        // Map中不允许出现重复的键，这里后面的键值对会覆盖掉前面的
        map.put(30,"c");
        map.put(40,"d");

        System.out.println("Map集合为：" + map);

        // 通过get(key的值)方法获取Map中的值
        // Map没有索引，所以无法通过普通for循环遍历
        System.out.println(map.get(10));

        // 获取所有key
        Set<Integer> set = map.keySet();
        for (int i : set){
            System.out.println(i);
        }

        // 获取所有value
        Collection<String> values = map.values();
        for (String s : values){
            System.out.println(s);
        }

        // 遍历map集合
        // 方法一：先获取key，通过key获取value
        Set<Integer> keySet = map.keySet();
        for (int i : keySet){
            System.out.println(i + "=" + map.get(i));
        }

        // 方法二：获取所有键值对
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer,String> m : entrySet){
            System.out.println(m);
        }

        // 根据 K 删除元素，返回对应的 V
        System.out.println(map.remove(20));

        // 判断集合是否为空
        System.out.println(map.isEmpty());
        System.out.println(map);

        // 判断集合是否包含指定的 K
        System.out.println(map.containsKey(2));

        // 判断集合是否包含指定的 V
        System.out.println(map.containsValue("c"));

        // 集合的长度
        System.out.println(map.size());

        // 清空集合
        map.clear();
    }
}
