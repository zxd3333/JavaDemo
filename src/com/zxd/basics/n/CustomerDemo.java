package com.zxd.basics.n;

//消费者
public class CustomerDemo implements Runnable{

    private MilkDemo milkDemo;
    public CustomerDemo(MilkDemo milkDemo){
        this.milkDemo = milkDemo;

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            milkDemo.getMilk();
        }
    }
}
