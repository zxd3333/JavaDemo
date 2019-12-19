package com.zxd.basics.look13.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 函数式接口的使用
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        //使用函数式接口
        LambdaInterfaceDemo demo = (int x,int y)-> {return x + y;};
        System.out.println(demo.add(10,20));

        // 函数式接口作为方法的参数，可以使用Lambda表达式作为参数传递
        method1(()-> System.out.println("函数式接口作为方法的参数，线程启动了"));

        ArrayList<String> array = new ArrayList<>();
        array.add("a");
        array.add("bb");
        array.add("ccd");

        Collections.sort(array,method2());
        System.out.println("按照方法二定义的方式（字符串定义的长度）进行输出：" + array);
    }

    // 使用此方法启动一个线程
    public static void method1(Runnable r){
        new Thread(r).start();
    }

    // 函数式接口作为方法的返回值，可以用Lambda表达式书写
    public static Comparator<String> method2(){
        return (o1,o2)->o1.length()-o2.length();
    }
}
