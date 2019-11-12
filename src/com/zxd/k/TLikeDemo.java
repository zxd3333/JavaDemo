package com.zxd.k;

import java.util.ArrayList;
import java.util.List;

//类型通配符：<?>
public class TLikeDemo {

    public static void main(String[] args) {

        //List<?>:元素类型未知的List，它的元素可以匹配任何类型的数据
        List<Integer> list1 = new ArrayList<>();
        list1.add(123);
        List<String> list2 = new ArrayList<>();
        list2.add("hello");

        show(list1);
        show(list2);

    }

    //所有List泛型都可以调用此方法进行输出
    public static void show(List<?> l){
        System.out.println(l.get(0));
    }

    //类型通配符上限，后面的都必须是指定类型或者它的子类
//    List<? extends Integer> list3 = new ArrayList<Number>(); //报错，因为Number是Integer的父类
    List<? extends Number> list4 = new ArrayList<Number>();
    //类型通配符下限，后面都必须是指定类型或者它的父类
//    List<? super Number> list5 = new ArrayList<Integer>(); //报错，因为Integer是Number的子类
    List<? super Number> list6 = new ArrayList<Object>();

    //这个不做演示了，因为我也是一知半解的样子，要想了解更多，还要查询资料
}
