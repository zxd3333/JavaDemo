package com.zxd.basics.look13;

// 停止线程
// 1.正常运行完毕后自己停止
// 2.通过外部标志位停止线程
public class ThreadStopDemo implements Runnable{

    // 定义标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("子线程..." + ": " + i++);
        }
    }

    // 自定义线程停止方法
    public void stop(){
        this.flag = false;
        System.out.println("停止");
    }

    public static void main(String[] args) {
        ThreadStopDemo demo = new ThreadStopDemo();
        // 启动线程
        new Thread(demo).start();

        // 主线程也有一个循环
        for (int i = 0; i < 1000; i++){
            System.out.println("main线程运行..." + ": " + i);
            if (i == 500){
                demo.stop();
            }
        }
    }
}
