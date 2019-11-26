package com.zxd.p;

//方法引用符
public class MethodReferenceDemo {

    public static void main(String[] args) {
        //匿名内部类使用
        new MethodReferenceInterface() {
            @Override
            public int show(String s) {
                return Integer.parseInt(s);
            }
        };
        //Lambda表达式
        useMethod(s->Integer.parseInt(s));
        //方法引用符,引用类方法
        useMethod(Integer::parseInt);

    }

    public static void useMethod(MethodReferenceInterface methodReferenceInterface){
        System.out.println(methodReferenceInterface.show("1000"));
    }

}
