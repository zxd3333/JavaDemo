package com.zxd.n;

//测试类
public class MilkTest {
    public static void main(String[] args) {
        MilkDemo milkDemo = new MilkDemo();
        ProductDemo p = new ProductDemo(milkDemo);
        CustomerDemo c = new CustomerDemo(milkDemo);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
    }
}
