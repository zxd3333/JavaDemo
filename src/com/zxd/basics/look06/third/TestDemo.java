package com.zxd.basics.look06.third;

// 测试类
public class TestDemo {

    public static void main(String[] args) {

        // 创建子类对象
        // 子类所有构造方法会默认访问父类无参构造方法(子类构造方法第一行默认调用父类的无参构造方法)
        /* 父类没有无参构造时(这句话意思是父类写了有参构造但没有写无参构造)，子类的构造方法要如何创建
                          (1).子类构造方法添加super(参数);语句，即可创建构造方法
                          (2).父类创建无参构造方法，这样子类也可以创建构造方法了
        */
        Cat cat = new Cat();

        // 子类调用父类中的方法
        cat.run();

        // 子类无法调用父类中的私有方法
        // cat.have();

        // 子类可以重写父类中的方法
        // @Override 注解修饰的方法是子类重写父类的方法
        cat.eat();

        // 子类可以有自己独有的方法
        cat.see();

        // 继承中this 和 super的了解
        cat.num();

        /* 子类父类中代码执行顺序:静态代码块->main方法->代码块->构造方法
           (1).静态代码块会随着类的加载而加载，所以会优先执行静态代码块
           (2).先执行父类静态代码块，再执行子类静态代码块，静态代码块只会执行一次
           (3).执行静态代码块之后会继续执行main方法，从上往下执行
           (4).创建对象时会首先执行父类的代码块和构造方法，再执行子类的代码块和构造方法
         */

        // 多态，父类引用指向子类对象
        Animal dog = new Cat();

        // 多态访问成员变量，访问的其实是父类的成员变量
        System.out.println(dog.num);

        // 多态访问方法，如果该方法被子类重写，那么访问的是子类重写的方法
        // 如果没有被重写，访问父类中的方法
        dog.eat();
        dog.run();

        // 可以通过强制类型转换访问子类的方法
        ((Cat) dog).see();
    }
}
