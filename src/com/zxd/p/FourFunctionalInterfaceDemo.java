package com.zxd.p;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//四大函数式接口：Supplier<T>、Consumer<T>、Predicate<T>、Function<T,R>
//简单了解
public class FourFunctionalInterfaceDemo {

    public static void main(String[] args) {

        //这里是Lambda表达式作为参数传递
        //也就是说最后会把max的值传递给getMax()方法
        //然后调用get()获取那个max并返回
        int[] num = {1,2,3,1,5,6,10,2};
        int maxNum = getMax(()->{
            int max = num[0];
            for (int i = 0; i < num.length; i++){
                if (num[i] > max){
                    max = num[i];
                }
            }
            return max;
        });
        System.out.println("Max = " + maxNum);


        //传入参数："赵某人"
        //进行操作：打印在控制台
        getName("赵某人",name -> System.out.println(name));
        //传入参数："赵某人"
        //进行操作1：打印在控制台
        //进行操作2：将内容反序并打印在控制台
        getName("赵某人",
                c1 -> System.out.println(c1),
                c2 -> System.out.println(new StringBuilder(c2).reverse().toString()));


        boolean b1 = testResult(103, integer -> integer > 100);
        System.out.println(b1);
        boolean b2 = andResult("Hello",
                p1->p1.length()>0,
                p2->p2.length()<0);
        System.out.println(b2);
        boolean b3 = orResult("Hi",
                p1->p1.length()>0,
                p2->p2.length()<0);
        System.out.println(b3);

        method1("100", s->Integer.parseInt(s));
        method2(200,i->String.valueOf(i));
        method3("150",
                s->Integer.parseInt(s),
                i->String.valueOf(i+150));

    }

    //Supplier<T>
    //get()作用是获取结果并返回
    //函数式接口作为方法的参数，可以用Lambda表达式作为参数传递
    public static int getMax(Supplier<Integer> supplier){
        return supplier.get();
    }

    //Consumer<T>
    //accept()方法是将传入的内容进行相关操作
    //一般这些操作都在Lambda表达式里面进行
    public static void getName(String name, Consumer<String> c){
        c.accept(name);
    }
    //方法重载
    //c1.andThen(c2).accept()方法是c1先使用accept()方法,c2再使用accept()方法
    public static void getName(String name,Consumer<String> c1,Consumer<String> c2){
        c1.andThen(c2).accept(name);
    }

    //Predicate<T>
    //通常用于判断参数是否满足指定条件
    //test()方法是对一个参数进行判断，返回一个布尔值
    //negate()方法是返回逻辑的否定
    //and(Predicate p)方法是返回
    //or(Predicate p)方法是返回
    public static boolean testResult(int i, Predicate<Integer> p){
        //直接调用test()方法，会返回本来的结果
        return p.test(i);
        //调用negate()方法再用test()会返回结果的否定
//        return p.negate().test(i);
    }
    //p1调用test()方法得到结果，p2在调用test()方法得到结果
    //对结果进行与操作
    public static boolean andResult(String s,Predicate<String> p1,Predicate<String> p2) {
        return p1.and(p2).test(s);
    }
    //p1调用test()方法得到结果，p2在调用test()方法得到结果
    //对结果进行或操作
    public static boolean orResult(String s,Predicate<String> p3,Predicate<String> p4) {
        return p3.or(p4).test(s);
    }

    //Function<T,R>
    //apply(T t)传入一个T类型的参数，进行相关操作之后返回一个R类型的结果
    //f1.andThen(f2).apply()方法是f1先使用apply()方法,f2再使用apply()方法
    public static void method1(String s, Function<String,Integer> f){
        System.out.println(f.apply(s));
    }
    public static void method2(int i, Function<Integer,String> f){
        System.out.println(f.apply(i));
    }
    public static void method3(String s, Function<String,Integer> f1, Function<Integer,String> f2){
        System.out.println(f1.andThen(f2).apply(s));
    }
}
