package com.zxd.basics.look13.lambda;

// Lambda表达式
public class LambdaDemo {

    public static void main(String[] args) {

        // 如果想启动一个线程，在控制台输出一句话
        // 正常情况下的做法，就是创建一个MyRunnable类实现Runnable接口
        // 然后再main方法中创建MyRunnable类的对象，把它作为参数传递给Thread对象
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();

        // 紧接着，我们看到这两个对象都只用了一次
        // 于是计划通过匿名内部类改进代码
        // 用了匿名内部类就不需要额外创建MyRunnable类了
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现多线程");
            }
        }).start();

        // 再然后，Lambda继续改进
        // 越改进越短了，也越看不太懂了
        new Thread( () -> System.out.println("Lambda实现多线程")).start();

        // 这里为什么要用Runnable来探究Lambda的使用呢
        // 因为Lambda使用的前提之一就是有一个函数式接口，Runnable正好是。哈哈哈


        // 下面通过我们自定义的函数式接口LambdaInterfaceDemo来使用一下Lambda表达式
        // Lambda表达式是函数式接口的一个实例
        // ()是传入的参数， {是重写的方法}
        int sum = method((int x, int y) -> {
            return x + y;
        });
        System.out.println(sum);

        // 简略模式写法
        // int sum = method((x,y)-> x+y);

        // 上面的Lambda的写法相当于下面的匿名内部类
        LambdaInterfaceDemo demo = new LambdaInterfaceDemo() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        };
        demo.add(10,20);
    }

    // Lambda使用的第二个前提就是必须有上下文环境，这样才能推导出Lambda接口
    // 方法的参数或局部变量类型必须为Lambda对应的那个接口的类型，才能使用Lambda作为该接口的实例
    public static int method(LambdaInterfaceDemo demo){
        return demo.add(100, 200);
    }
}
