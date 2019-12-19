package com.zxd.basics.look13.lock;

// 取钱中使用synchronized
public class SynchronizedDemo2 {

    public static void main(String[] args) {
        Account account = new Account(100);
        Bank a = new Bank(account,50);
        Bank b = new Bank(account,100);

        new Thread(a,"小黑").start();
        new Thread(b,"小白").start();
    }
}

// 账户
class Account{

    // 银行卡余额
    int money;

    public Account(int money) {
        this.money = money;
    }
}

// 银行，模拟取钱
class Bank implements Runnable{

    Account account;
    // 想取多少钱
    int takeMoney;
    // 手里现在有多少钱
    int haveMoney;

    public Bank(Account account,int takeMoney){
        this.account = account;
        this.takeMoney = takeMoney;
    }
    @Override
    public void run() {
        // 给账户对象(account)加上锁，锁的是账户，外面的线程访问的是同一个账户，同时只能有一个访问
        synchronized (account) {
            if (account.money - takeMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，取不出来");
            } else {
                // 模拟延时
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 卡内余额 = 卡内余额 - 想取走的钱
                account.money = account.money - takeMoney;
                // 手里的钱 = 手里的钱 + 想取走的钱
                haveMoney = haveMoney + takeMoney;

                System.out.println("账户余额：" + account.money);
                System.out.println(Thread.currentThread().getName() + "手里的钱为：" + haveMoney);
            }
        }
    }
}
