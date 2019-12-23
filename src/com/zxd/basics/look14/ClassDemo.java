package com.zxd.basics.look14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        // 获取一个类的Class对象
        // 方法一：通过类对象的getClass方法
        Student s = new Student();
        Class c1 = s.getClass();

        // 方法二：通过Class类中的forName方法获得
        Class c2 = Class.forName("com.zxd.basics.look14.Student");

        // 方法三：通过类名.class获得
        Class c3 = Student.class;

        // 反射获取构造方法对象
        // 第一步：获取类的Class对象
        Class c4 = Student.class;
        // 第二步：获取构造方法对象
        //        getConstructors获取所有public修饰的构造方法对象
        //        getDeclaredConstructors 获取所有构造方法对象
        Constructor[] con1 = c4.getConstructors();
        Constructor[] con2 = c4.getDeclaredConstructors();

        // 通过反射生成对象
        // 方法一：通过newInstance方法创建Student的实例
        // 第一步：获取类的Class对象
        Class c5 = Student.class;
        // 第二步：获取实例，这里创建的是无参的Student对象
        Object o = c5.newInstance();

        // 方法二：通过构造器对象的newInstance方法创建Student的实例
        // 第一步：获取类的Class对象
        Class c6 = Student.class;
        // 第二步：获取构造器对象(无参)
        Constructor con3 = c6.getConstructor();
        // 第二步：获取构造器对象(有参)
        Constructor con4 = c6.getConstructor(String.class,int.class);
        // 第三步：获取Student实例(无参)
        Object o1 = con3.newInstance();
        // 第三步：获取Student实例(有参)
        Object o2 = con4.newInstance( "小黑",1);
        System.out.println(o1);
        System.out.println(o2);

        // 对于Student类中的私有构造器
        // 可以利用暴力反射通过私有构造器创建对象
        // 第一步：获取类的Class对象
        Class c7 = Student.class;
        // 第二步：获取私有构造器对象
        Constructor con5 = c7.getDeclaredConstructor(int.class);
        // 第三步：采用暴力反射setAccessible(boolean flag)，当传入参数为true，可以取消访问检查
        con5.setAccessible(true);
        // 第四步：创建Student的实例
        Object o3 = con5.newInstance(2);
        System.out.println(o3);

        // 反射获取成员变量
        // 第一步：获取类的Class对象
        Class c8 = Student.class;
        // 第二步：获得成员对象
        //        getFields获取public修饰的成员对象
        //        getDeclaredFields获取所有成员对象
        Field[] f1 = c8.getFields();
        for (Field f : f1){
            System.out.println(f);
        }
        Field[] f2 = c8.getDeclaredFields();
        for (Field f : f2){
            System.out.println(f);
        }

        // 反射使用成员变量
        // 第一步：创建Student的实例
        Class c9 = Student.class;
        Object o4 = c9.newInstance();
        // 第二步：获取成员对象并赋值
        // public修饰的
        Field idField = c8.getField("id");
        idField.set(o4,10);
        // private修饰的
        Field ageField = c9.getDeclaredField("age");
        // 类中私有的东西操作前都要开启暴力反射
        ageField.setAccessible(true);
        ageField.set(o4,15);
        System.out.println(o4);

        // 反射获取方法对象
        // getMethod获取本类以及本类继承的类的公共方法对象
        // getDeclaredMethods获取本类中的所有方法对象
        Class c10 = Student.class;
        Method[] m1 = c10.getMethods();
        Method[] m2 = c10.getDeclaredMethods();
        for (Method m : m1){
            System.out.println(m);
        }
        System.out.println("---------------");
        for (Method m : m2){
            System.out.println(m);
        }

        // 反射使用公共方法
        // 创建Student实例
        Constructor con6 = c10.getConstructor();
        Object o5 = con6.newInstance();
        Method m3 = c10.getMethod("m1",null);
        m3.invoke(o5);

        // 反射使用私有方法
        Method m4 = c10.getDeclaredMethod("m2",null);
        // 只要是私有的都要暴力反射
        m4.setAccessible(true);
        m4.invoke(o5);

    }
}
