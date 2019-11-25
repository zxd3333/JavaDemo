package com.zxd.p;

//函数式接口
//Java中函数式编程体现的就是Lambda表达式
public class FunctionInterfaceDemo {

    public static void main(String[] args) {
        //函数式接口的使用
        //Lambda表达式表示该接口的一个实现
        MyFunctionInterface mfi = ()-> System.out.println(123);
        mfi.show();

        //匿名内部类调用函数式接口
        method1(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类调用");
            }
        });

        //Lambda表达式调用
        method1(()-> System.out.println("Lambda表达式调用"));

    }

    //查看源码发现Runnable接口是一个函数式接口
    //如果一个方法的参数是一个函数式接口，我们可以把Lambda表达式作为参数传递
    public static void method1(Runnable runnable){
        new Thread(runnable).start();
    }
}

