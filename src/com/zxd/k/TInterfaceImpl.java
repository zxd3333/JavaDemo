package com.zxd.k;

//泛型接口实现类
//如果此处确定了泛型的类型，那么方法中的泛型也会确定
//声明类的时候，可以将泛型的声明也一起加到类中
public class TInterfaceImpl implements TInterfaceDemo<Integer> {

    @Override
    public Integer show() {
        return 666;
    }
}
