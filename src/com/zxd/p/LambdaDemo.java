package com.zxd.p;

//了解Lambda表达式
public class LambdaDemo {

    public static void main(String[] args) {

        //如果想启动一个线程，在控制台输出一句话
        //正常情况下的做法，就是创建一个MyRunnable类实现Runnable接口
        //然后再main方法中创建MyRunnable类的对象，把它作为参数传递给Thread对象
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();

        //由于这两的对象都只是是用了一次，所以可以用匿名内部类改进
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程启动了！！");
            }
        }).start();

        //这里用Lambda表达式改进来演示Lambda表达式的用法
        new Thread( () -> {
            System.out.println("多线程启动了！！！");
        } ).start();

        //Lambda表达式的使用
        //使用前，我们定义了一个函数式接口 LambdaInterface
        use((int x, int y)->{
            return x+y;
        });

        //省略模式
        use((x,y)->x+y);
    }
    public static void use(LambdaInterface lambdaInterface){
        System.out.println(lambdaInterface.add(100,200));
    }
}
