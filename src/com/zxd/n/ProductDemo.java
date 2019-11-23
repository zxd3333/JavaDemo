package com.zxd.n;

//生产者
public class ProductDemo implements Runnable{

    private MilkDemo milkDemo;
    public ProductDemo(MilkDemo milkDemo){
        this.milkDemo = milkDemo;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            milkDemo.setMilk(i);
        }
    }
}
