package com.zxd.basics.look09;

public class MyException  extends Exception{

    private String str;

    public  MyException(){

    }

    public MyException(String str){
        this.str = str;
    }

    public String toString(){
        return "MyException: [ " +
                str + " ]";
    }
}
