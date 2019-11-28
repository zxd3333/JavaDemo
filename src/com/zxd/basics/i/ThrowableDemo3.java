package com.zxd.basics.i;

//try...catch...finally
public class ThrowableDemo3 {

    public static void main(String[] args) {
        try{
            int a = 100;
            for (int i = 2; i > -1; i--){
                System.out.println(100/i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally常用于编写释放资源的代码");
            System.out.println("finally总会被执行，除非程序退出或者线程中断");
        }
    }
}
