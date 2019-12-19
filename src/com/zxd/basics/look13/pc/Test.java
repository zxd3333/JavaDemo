package com.zxd.basics.look13.pc;

// 生产者消费者模式
public class Test {

    public static void main(String[] args) {
        MilkBox milkBox = new MilkBox();
        Product p = new Product(milkBox);
        Customer c = new Customer(milkBox);

        new Thread(p).start();
        new Thread(c).start();
    }

}

// 消费者
class Customer implements Runnable{

    // 拿到容器
    private MilkBox box;
    public Customer(MilkBox box){
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            box.getMilk();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 生产者
class Product implements Runnable{

    private MilkBox box;
    public Product(MilkBox box){
        this.box = box;
    }
    @Override
    public void run() {
        for (int i = 1; i < 10; i++){
            box.setMilk(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


// 产品
class MilkBox{
    // 定义一个变量，用来记录牛奶瓶数
    private int count;
    // 定义一个标志，用来记录盒子是否为空，默认为空
    private boolean flag = true;

    public synchronized void setMilk(int count){
        // 如果没有牛奶就生产牛奶，并修改标志位，唤醒消费者消费
        if (flag){
            this.count = count;
            System.out.println("生产了第" + count + "瓶牛奶");
            flag = false;
            notifyAll();
        }else {
            // 如果有牛奶就等待消费者消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void getMilk(){
        // 如果没有牛奶就等待
        if (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // 如果有牛奶就消费，消费完毕后修改标志位，同时唤醒生产者生产
            System.out.println("消费了第" + this.count + "瓶牛奶");
            flag = true;
            notifyAll();
        }
    }
}
