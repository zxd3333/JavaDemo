package com.zxd.o;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

//反射与配置文件
public class ClassPropertiesDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties p = new Properties();
        FileReader fr = new FileReader("src\\com\\zxd\\o\\ClassDemo.properties");
        //读取文件
        p.load(fr);
        fr.close();
        //获取类名和方法名
        String className = p.getProperty("className");
        String mName = p.getProperty("mName");
        //获取类对象
        Class<?> c = Class.forName(className);
        //根据构造方法对象使用newInstance()创建对象
        Constructor<?> constructor = c.getConstructor();
        Object o = constructor.newInstance();

        //如果方法是公有的
        //获得成员方法对象
        Method method = c.getMethod(mName);
        //方法调用
        method.invoke(o);

        //如果方法是私有的
//        Method method = c.getDeclaredMethod(mName);
//        method.setAccessible(true);
//        method.invoke(o);
    }
}
