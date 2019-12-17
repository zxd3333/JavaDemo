package com.zxd.basics.look09;

// 异常抛出
// throw 抛出异常
// throws 添加在方法名之后，谁调用这个方法，就把异常抛给谁，但是最后还是要解决异常
public class ThrowsDemo {

    public static void main(String[] args) throws MyException {
        // 方法一：在方法中捕获异常
        ThrowsDemo demo = new ThrowsDemo();
        try {
            demo.method2();
        } catch (MyException e) {
            e.printStackTrace();
        }
        /* 方法二：在main方法上也抛出异常
            ThrowsDemo t = new ThrowsDemo();
            t.method2();
         */
    }

    public void method2() throws MyException {
        method1();
    }

    public void method1() throws MyException{
        throw new MyException("抛出异常");
    }
}
