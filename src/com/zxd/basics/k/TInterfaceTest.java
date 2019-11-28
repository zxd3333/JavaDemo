package com.zxd.basics.k;

//泛型接口测试类
public class TInterfaceTest {

    public static void main(String[] args) {

        //根据实现类中的类型来确定这里的类型
        TInterfaceDemo<Integer> t = new TInterfaceImpl();
        System.out.println(t.show());
    }
}
