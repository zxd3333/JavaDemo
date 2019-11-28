package com.zxd.basics.k;

//泛型：本质上就是参数化类型，在使用或者调用的时候再传入具体的类型
//泛型类、泛型方法、泛型接口、泛型通配符
//总之，泛型可以指代任何类型，定义的时候不需要专门定义
//使用的时候它会根据我们指定的类型变化而变化
public class TClassDemo<T> {

    //这个成员变量的类型为T,T的类型由外部指定
    private T name;

    public T getT(){
        return name;
    }

    public void setT(T name){
        this.name = name;
    }

    //泛型方法
    //我们调用show()方法时，输入什么类型的参数，T t就会转变为什么类型
    public <T> void show(T t){
        System.out.println(t);
    }
}
