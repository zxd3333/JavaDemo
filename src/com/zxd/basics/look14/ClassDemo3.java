package com.zxd.basics.look14;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

// 反射读取配置文件
public class ClassDemo3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties p = new Properties();
        FileReader fr = new FileReader("src\\com\\zxd\\basics\\look14\\ClassDemo.properties");
        // 读取文件
        p.load(fr);
        fr.close();
        // 获取类名和方法名
        String className = p.getProperty("className");
        String publicName = p.getProperty("mName1");
        String privateName = p.getProperty("mName2");
        // 获取类对象
        Class c = Class.forName(className);
        // 根据构造方法对象使用newInstance()创建对象
        Constructor con = c.getConstructor();
        Object o = con.newInstance();

        // 如果方法是public修饰的
        // 获得方法对象
        Method method = c.getMethod(publicName);
        // 方法调用
        method.invoke(o);

        // 如果方法是私有的
        Method method2 = c.getDeclaredMethod(privateName);
        method2.setAccessible(true);
        method2.invoke(o);
    }
}
