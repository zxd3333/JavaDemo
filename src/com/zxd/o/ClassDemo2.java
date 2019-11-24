package com.zxd.o;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

//反射越过泛型检测
public class ClassDemo2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arr = new ArrayList<>();
        //此时arr集合中只能添加Integer类型的元素，否则编译时会报错
        //arr.add("hi");   //报错

        //运用反射我们可以越过检测
        //获取集合的Class对象
        Class<? extends ArrayList> c = arr.getClass();
        //返回方法对象
        //传入add()方法的方法名add和参数类型，我们把Integer.class改成Object.class
        Method add = c.getMethod("add", Object.class);
        //arr调用add，传入"hello"字符串
        add.invoke(arr,"hello");
        System.out.println(arr);
    }
}
