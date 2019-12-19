package com.zxd.basics.look13.staticProxy;

// 静态代理
// 代理角色
// 这个是中介(这个类名就是中介的意思，不百度一下中介的英文怎么说我可能一辈子都不认识)
// 中介帮助房东出租房子，所以他也要实现租房的接口表明到他这儿也可以租房
// 但是他是代理，代理别人，不是自己要出租房子，所以他需要拿到房东的信息，发布房东租房的方法
// 但是在租房前，他要跟房东签合同，然后房子租出去了他得给房东钱
// 房东自由了，中介赚差价。哎~~~
public class Agency implements Rent{

    // 拿到房东信息
    // 被代理的类
    private Host host;
    public Agency(Host host){
        this.host = host;
    }

    @Override
    public void rent() {
        before();
        host.rent();
        after();
    }

    private void after() {
        System.out.println("中介说：房子租出去了，我把租金给你了");
    }

    private void before() {
        System.out.println("中介说：我帮你租房子，你要跟我签合同");
    }


}
