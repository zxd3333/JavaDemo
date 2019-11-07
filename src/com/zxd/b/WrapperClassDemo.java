package com.zxd.b;

//包装类
//基本数据类型和引用数据类型转换的桥梁
public class WrapperClassDemo {

    public static void main(String[] args) {
        //int 和 String 的互相转换
        //int -> String:方式一
        int a = 10;
        String s = " " + a;
        System.out.println(s);
        //int -> String:方式二
        String s1 = String.valueOf(a);
        System.out.println(s1);

        //String -> int:方式一
        String s2 = "1234";
        Integer integer = Integer.valueOf(s2);
        int x = integer.intValue();
        System.out.println(x);

        //String -> int:方式二
        int x1 = Integer.parseInt(s2);
        System.out.println(x1);

        //装箱和拆箱
        //valueOf()方法：首先判断内容是否在缓存池中，在的话直接返回缓存池中的内容，不用新建对象
        //装箱:把基本数据类型转换为对应的包装类
        int i = 100;
        Integer i1 = Integer.valueOf(i);

        //这样写Java会自动装箱
        Integer i2 = 100;

        System.out.println(i1 == i2);//true

        //拆箱:把包装类转换为基本数据类型
        //首先定义一个包装类
        //然后通过对应方法的到基本数据类型
        Integer i3 = Integer.valueOf(100);
        int i4 = i3.intValue();

        //自动拆箱
        //自动拆箱则不需要显式地写方法
        Integer i5 = Integer.valueOf(100);
        int i6 = i5;
    }
}
