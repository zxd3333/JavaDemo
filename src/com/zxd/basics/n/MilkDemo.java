package com.zxd.basics.n;

//生产者消费者
//买牛奶：有一个盒子用来放牛奶
//       生产者看到里面是空的，就生产并往里面放了牛奶，放第二瓶的时候发现里面有了牛奶，
//       就等待消费者消费，然后消费者看到里面有牛奶了，就拿走牛奶，然后唤醒生产者生产
public class MilkDemo {

    //定义一个变量，用来记录牛奶瓶数
    private int milk;
    //定义一个标志，用来记录盒子是否为空
    private boolean flag = true;

    //生产者生产牛奶
    public void setMilk(int milk) {
        synchronized (this){
            //如果牛奶盒子是空的，就添加牛奶，并将牛奶盒子修改为不空，同时唤醒消费者
            if (flag == true){
                this.milk = milk;
                System.out.println("生产者添加第" + this.milk + "瓶牛奶");
                flag = false;
                notifyAll();
            }else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者消费
    public void getMilk(){
        synchronized (this) {
            //如果牛奶盒子不是空的，那就拿走里面的牛奶，然后把盒子状态修改为空，同时唤醒生产者
            if (flag == false) {
                System.out.println("消费者拿走第" + this.milk + "瓶牛奶");
                flag = true;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
