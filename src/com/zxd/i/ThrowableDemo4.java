package com.zxd.i;

//自定义异常的使用
public class ThrowableDemo4 {

    //方式一：在执行代码的时候添加try...catch语句
    public static void main(String[] args) {
        ThrowableDemo4 demo = new ThrowableDemo4();
        try {
            demo.Exc1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //方式二：直接在方法名后throws 异常，然后正常调用方法
//    public static void main(String[] args) throws MyException {
//        ThrowableDemo4 demo = new ThrowableDemo4();
//        demo.Exc1();
//    }

    public void Exc1() throws MyException{
        try{
            //调用Exc()方法，捕获处理异常
            Exc();
        }catch (MyException m){
            //将捕获到的异常继续往上抛，抛给调用Exc1()方法的对象
            throw m;
        }
    }

    public void Exc() throws MyException{
        //将异常抛出，谁调用这个方法就抛给谁
        throw new MyException("这个异常是Exc2()抛出的异常");
    }
}
