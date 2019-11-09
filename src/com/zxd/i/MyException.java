package com.zxd.i;

//自定义异常类
public class MyException extends Exception {

    public MyException(){

    }
    //参数是作为异常对象除了异常类型的额外说明
    //参数是调用类中抛出异常后的提示信息
    public MyException(String s){
        super(s);
    }
}
