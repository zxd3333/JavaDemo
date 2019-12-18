package com.zxd.basics.look11;

import java.util.ArrayList;
import java.util.List;

// 测试类
public class GenericDemoTest {

    public static void main(String[] args) {

        // 实例化泛型类的时候，必须指定泛型T的类型
        GenericDemo<String> genericDemo = new GenericDemo<>();
        genericDemo.setT("Hello");
        System.out.println(genericDemo.getT());
        genericDemo.method(123);

        // 不指定类型时，可以传入任意类型的参数
        GenericDemo demo = new GenericDemo();
        demo.setT(12345);
        System.out.println(demo.getT());
        demo.setT("Hello");
        System.out.println(demo.getT());
        demo.method(123);

        // 调用泛型接口
        GenericInterfaceDemo<String> genericInterfaceDemo = new GenericImpl();
        System.out.println(genericInterfaceDemo.show());

        // 类型通配符
        TLikeDemo likeDemo = new TLikeDemo();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        likeDemo.like(integerList);

        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        likeDemo.like(stringList);
    }
}
