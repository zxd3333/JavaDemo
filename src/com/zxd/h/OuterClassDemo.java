package com.zxd.h;

//成员内部类的使用
//成员内部类，跟成员变量同一级
public class OuterClassDemo {

    private int num = 100;

    //定义普通内部类
    private class Inner{
        private int num = 50;
        //内部类可以访问外部类的成员变量
        public void innerShow(){
            int num = 25;
            //就近原则
            System.out.println(num);
            //this代表所在类的对象的引用，这里就是内部类的成员变量
            System.out.println(this.num);
            //访问外部类的成员变量
            System.out.println(OuterClassDemo.this.num);
            outerShow();
        }
    }

    //定义静态内部类
    private static class StaticInner{
        private int num = 12;
        public void staticInnerShow(){
            System.out.println(num);
            //静态内部类访问外部类的成员变量和成员方法时，都需要实例化外部类
            System.out.println(new OuterClassDemo().num);
            new OuterClassDemo().outerShow();
        }
    }

    //外部类的方法
    public void outerShow(){
        System.out.println("外部类的方法");
//        普通方法访问内部类
//        Inner inner = new Inner();
//        inner.innerShow();
    }

    //说到底，main()方法也是静态方法
    public static void main(String[] args) {
        //静态方法访问普通内部类，要先实例化外部类，在通过外部类对象实例化内部类
        Inner inner = new OuterClassDemo().new Inner();
        inner.innerShow();

        //静态方法访问静态内部类，直接实例化即可
        StaticInner staticInner = new StaticInner();
        staticInner.staticInnerShow();

        //静态方法访问本类中的普通方法，不知道还记不记得，应该要先实例化本类的对象
        OuterClassDemo o = new OuterClassDemo();
        o.outerShow();
    }
}
