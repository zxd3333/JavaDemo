package com.zxd.l;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map<K,V>是一个接口
//键值对一一对应
//不能包含重复的键
public class MapDemo {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"a");
        map.put(3,"b");
        //Map中不允许出现重复的键，这里后面的键值对会覆盖掉前面的
        map.put(3,"c");
        System.out.println("Map集合为：" + map);

        //通过get(key的值)方法获取Map中的值
        //Map没有索引，所以无法通过普通for循环遍历
        System.out.println("Map中1对应的值为：" + map.get(1));

        //获取所有Key
        Set<Integer> key = map.keySet();
        System.out.print("Map中所有的Key为：");
        for (int i : key){
            System.out.print(i + " ");
        }

        System.out.println();

        //获取所有Value
        Collection<String> c = map.values();
        System.out.print("Map中所有的Value为：");
        for (String s : c){
            System.out.print(s + " ");
        }

        System.out.println();

        //遍历Map集合
        //方式一：先获取Key，在根据Key获取Value
        Set<Integer> set = map.keySet();
        System.out.print("集合中所有键值对为：");
        for (int k1 : set){
            System.out.print(k1 + "," + map.get(k1) + " ");
        }

        System.out.println();

        //方式二：先获取所有的键值对对象的集合，再遍历集合获取所有键值对
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        System.out.print("集合中所有键值对为：");
        for (Map.Entry<Integer,String> maps : entrySet){
            System.out.print(maps.getKey() + "," + maps.getValue() + " ");
        }

        System.out.println();
        //根据 K 删除元素，返回对应的 V
        System.out.println(map.remove(2));
        //判断集合是否为空
        System.out.println(map.isEmpty());
        System.out.println(map);
        //判断集合是否包含指定的 K
        System.out.println(map.containsKey(2));
        //判断集合是否包含指定的 V
        System.out.println(map.containsValue("c"));
        //集合的长度
        System.out.println(map.size());
        //清空集合
        map.clear();
    }
}
