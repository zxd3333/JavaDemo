package com.zxd.basics.look11;

// 泛型接口的实现类
// 实现接口的时候可以指定泛型类型
// 如果实现接口的时候没有指明泛型类型，在方法中也可以直接使用，但是我觉得这样不规范
public class GenericImpl implements GenericInterfaceDemo<String> {
    @Override
    public String show() {
        return "Hello World!";
    }
}
