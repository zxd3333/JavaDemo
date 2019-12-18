package com.zxd.basics.look11;

import java.util.ArrayList;
import java.util.List;

// <?>：类型通配符
public class TLikeDemo {

    // 此处List<?> 可以匹配任何类型的List
    // 此处只是介绍一下<?>可以这么用，毕竟人家List<E>已经是一个泛型接口了嘛
    public void like(List<?> list){
        System.out.println(list);
    }

    // 类型通配符上限
    // <? extends Integer> 中，? 处的类型必须是Integer或者Integer的子类
    // List<? extends Integer> list1 = new ArrayList<Number>(); //报错，因为Number是Integer的父类
    List<? extends Number> list2 = new ArrayList<Number>();

    // 类型通配符下限
    // <? super Number> 中，? 处的类型必须是Number或者它的父类
    // List<? super Number> list3 = new ArrayList<Integer>(); //报错，因为Integer是Number的子类
    List<? super Number> list4 = new ArrayList<Object>();
}
