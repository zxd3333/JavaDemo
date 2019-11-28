package com.zxd.basics.q;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//收集流
public class CollectStreamDemo {

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("赵某人");
        arr.add("张某人");
        arr.add("张吃撑");
        arr.add("招收自");
        arr.add("哈哈");

        Stream<String> stringStream = arr.stream().filter(s -> s.length() > 2);
        //将流中的数据保存到list集合当中，使用collect(Collector c)方法
        //但是这个参数Collector是一个接口，不能直接使用
        //于是使用Collectors类中的toList()方法
        stringStream.collect(Collectors.toList()).forEach(System.out::println);

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        Stream<Integer> setStream = set.stream().filter(a -> a > 25);
        //使用Collectors类中的toSet()方法
        //将数据保存在set集合当中
        setStream.collect(Collectors.toSet()).forEach(System.out::println);

        //将字符串中的数据存入Map集合，姓名为键，年龄为值
        String[] str = {"哈哈,20","呵呵,60","嘻嘻,80"};
        Stream<String> strStream = Stream.of(str).filter(s -> Integer.parseInt(s.split(",")[1]) > 25);
        Map<String, Integer> map = strStream.collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        Set<String> keySet = map.keySet();
        for (String key :keySet){
            Integer value = map.get(key);
            System.out.println(key+","+value);
        }
    }
}
