package com.zxd.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//函数式接口
//Java中函数式编程体现的就是Lambda表达式
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        //函数式接口的初步使用
        //接口不能实例化，可以使用Lambda表达式表示该接口的一个实现
        MyFunctionInterface mfi = ()-> System.out.println(123);
        mfi.show();

        //函数式接口作为方法的参数
        //如果一个方法的参数是一个函数式接口，我们可以把Lambda表达式作为参数传递
        //正常情况下，使用匿名内部类调用函数式接口
        method1(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类调用");
            }
        });

        //与之对比，采用Lambda表达式作为参数传递
        method1(()-> System.out.println("Lambda表达式调用"));

        //函数式接口作为方法的返回值
        //当一个方法的返回值是一个函数式接口，可以把Lambda表达式作为结果返回
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("bb");
        arrayList.add("dd");
        arrayList.add("cccc");

        System.out.println("按录入的顺序输出：" + arrayList);
        Collections.sort(arrayList);
        System.out.println("按照A~Z的顺序输出：" + arrayList);
        Collections.sort(arrayList,method2());
        System.out.println("按照自定义的顺序(字符串的长度)输出：" + arrayList);

    }

    //查看源码发现Runnable接口是一个函数式接口
    //如果一个方法的参数是一个函数式接口，我们可以把Lambda表达式作为参数传递
    public static void method1(Runnable runnable){
        new Thread(runnable).start();
    }

    //查看源码发现Comparator<T> 是一个函数式接口
    //作用是对数组进行排序
    //当一个方法的返回值是一个函数式接口，可以把Lambda表达式作为结果返回
    public static Comparator<String> method2(){
        return (o1,o2)->o1.length() - o2.length();
    }

}

