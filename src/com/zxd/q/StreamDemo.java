package com.zxd.q;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

//Stream流
public class StreamDemo {

    public static void main(String[] args) {
        //生成流的方法

        //1.数组可以通过Stream接口的静态方法of(T...values)生成流
        String[] str = {"a","b","c"};
        //可以将数组名传入生成流
        Stream<String> str1Stream = Stream.of(str);
        //也可以直接将数组元素传入生成流
        Stream<String> str2Stream = Stream.of("a", "b", "c");

        //2.Collections体系的集合可以通过默认方法stream()生成流
        List<String> listStream = new ArrayList<>();
        listStream.stream();

        //3.Map体系的集合间接生成流
        Map<String,Integer> map = new HashMap<>();
        //根据(key)键生成键的流
        Stream<String> keyStream = map.keySet().stream();
        //根据(value)值生成值的流
        Stream<Integer> valueStream = map.values().stream();
        //根据(entrySet)键值对生成键值对的流
        Stream<Map.Entry<String,Integer>> entryStream = map.entrySet().stream();


        //流的中间操作
        //这里创建一个集合来使用流
        ArrayList<String> arr = new ArrayList<>();
        arr.add("赵某人");
        arr.add("张某人");
        arr.add("张三");
        arr.add("赵四");
        arr.add("哈哈哈哈哈");

        //filter的使用
        //filter(Predicate p)：对流中的信息过滤
        //Predicate接口中的test()方法可以对给定参数进行判断
        //生成流并使用filter进行中间操作，运用foreach进行终结操作
        arr.stream().filter(s -> s.startsWith("赵")).forEach(System.out::println);
        System.out.println("======");
        arr.stream().filter(s -> s.length()>2).forEach(System.out::println);
        System.out.println("======");
        arr.stream().filter(s -> s.length()>2)
                .filter(s -> s.startsWith("赵"))
                .forEach(System.out::println);
        System.out.println("======");

        //limit 和 skip的使用
        //limit(i)方法是截取前i个数据
        //skip(i)方法是跳过前i个数据
        arr.stream().limit(3).forEach(System.out::println);
        System.out.println("======");
        arr.stream().skip(3).forEach(System.out::println);
        System.out.println("======");
        arr.stream().skip(2).limit(2).forEach(System.out::println);
        System.out.println("======");

        //concat(Stream a,Stream b) 和 distinct的使用
        //concat(Stream a,Stream b)方法是合并两个流
        //distinct()方法是去掉重复的元素
        Stream<String> stream1 = arr.stream().limit(3);
        Stream<String> stream2 = arr.stream().skip(2).limit(2);
        Stream.concat(stream1,stream2).forEach(System.out::println);
//        Stream.concat(stream1,stream2).distinct().forEach(System.out::println);
        System.out.println("======");

        //sorted() 和 sorted(Comparator c)的使用
        //sorted()方法是按照首字母顺序进行排序
        arr.stream().sorted().forEach(System.out::println);
        //sorted(Comparator c)方法是按照我们给定的比较器进行排序
        //这里给定的是按照数据的长度进行比较
        arr.stream().sorted((s1,s2)->s1.length()-s2.length()).forEach(System.out::println);
        //第二种方法中，字符串长度相同时，会默认按照添加顺序进行排序
        //为了让字符串在长度相同时仍按照a~z的顺序进行排序，我们给出优化
        //首先在后面继续使用sorted()方法，结果发现会把我们给定比较器的排序方法给覆盖掉
        //于是只能在Lambda表达式中做修改
        arr.stream().sorted((s1,s2)->{
            int num = s1.length() - s2.length();
            //当长度相同时，我们比较两个字符串内容
            //compareTo()返回1，表示ASCII值 s1-s2>0,即字母表中s1比s2靠后
            int num2 = num==0?s1.compareTo(s2):num;
            return num2;
        }).forEach(System.out::println);

        ArrayList<String> array = new ArrayList<>();
        array.add("1");
        array.add("11");
        array.add("12");
        array.add("2");
        array.add("5");
        //map(Function f) 和 mapToInt(ToIntFunction tif)方法
        //map(Function f)方法是流和函数式接口Function<T,R>的结合使用
        array.stream().map(s -> Integer.parseInt(s)).forEach(System.out::println);
        //mapToInt()方法会返回一个IntStream，因此可以使用IntStream中的方法
        int sum = array.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(sum);


        //终结流
        //foreach(Consumer c) 和 count()的使用
        //forEach()方法是对流的每个元素执行操作
        arr.stream().forEach(System.out::println);
        //count()方法是最后返回此流中的元素数，结果是一个long类型
        long l = arr.stream().count();
        System.out.println(l);
    }

}
