package com.zxd.basics.p;

//Lambda所依赖的接口——函数式接口
@FunctionalInterface
public interface LambdaInterface {
    int add(int x, int y);
    //函数式接口只能有一个抽象方法，当出现第二个方法时会报错
    //void say();
}
