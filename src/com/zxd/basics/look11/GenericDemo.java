package com.zxd.basics.look11;

// 泛型类
public class GenericDemo<T> {

    // 成员变量的数据类型为T，T的类型由外部指定
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    // 泛型方法
    // 在修饰符和返回值类型之间添加 <T> 即声明此方法为泛型方法
    // 外部调用此方法时，输入什么类型的参数，T t就会转变为什么类型
    public <T> void method(T t){
        System.out.println("泛型方法输出：" + t);
    }
}
