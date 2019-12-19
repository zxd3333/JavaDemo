package com.zxd.basics.look13;

import java.util.concurrent.*;

// 实现Callable接口
// 这种方法实现多线程可以有返回值，前两种没有
// 可以给Callable接口设置泛型类型，如果设置了泛型类型，call()方法也要返回对应类型
public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo c1 = new CallableDemo();
        CallableDemo c2 = new CallableDemo();
        CallableDemo c3 = new CallableDemo();

        // 这是它跟前两种方法不一样的地方
        // 1.创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        // 2.提交执行
        Future<Integer> r1 = service.submit(c1);
        Future<Integer> r2 = service.submit(c2);
        Future<Integer> r3 = service.submit(c3);

        // 3.获取结果
        Integer i1 = r1.get();
        Integer i2 = r2.get();
        Integer i3 = r3.get();

        // 4.关闭服务
        service.shutdownNow();
    }
}
