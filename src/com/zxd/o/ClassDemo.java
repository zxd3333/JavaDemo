package com.zxd.o;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//反射
public class ClassDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        //反射获取一个类的Class对象的三个方法
        //方法一：使用类的class属性来获取该类对应的Class对象
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);

        //方法二：调用对象的getClass()方法，返回对象所属类对应的Class对象
        Student student = new Student();
        System.out.println(student.getClass());

        //方法三：使用Class类中的静态方法forName(String className)方法
        Class<?> forNameClass = Class.forName("com.zxd.o.Student");
        System.out.println(forNameClass);

        //反射获取构造方法对象
        //首先获取Student类的Class对象
        Class<?> s = Class.forName("com.zxd.o.Student");
        //此方法只能得到public修饰的构造方法的对象
        Constructor[] cons1 = s.getConstructors();
        for (Constructor con : cons1){
            System.out.println(con);
        }

        //此方法可以得到所有构造方法对象
        Constructor[] cons2 = s.getDeclaredConstructors();
        for (Constructor con : cons2){
            System.out.println(con);
        }

        //通过反射生成对象的两个方法
        //方法一：使用Class对象的newInstance()方法来创建Class对象对应类的实例
        //只能创建无参的对象
        Object o1 = s.newInstance();
        System.out.println(o1);

        //方法二：先通过Class对象获取指定的Constructor对象
        //再调用Constructor对象的newInstance()方法来创建对象
        //可以根据getConstructor()方法创建带参的对象
        Constructor<?> con1 = s.getConstructor(int.class,String.class,int.class);
        Object obj = con1.newInstance(1,"赵",18);
        System.out.println(obj);

        //获取private修饰的带参构造方法对象
        //通过getDeclaredConstructor()方法
        Constructor<?> con2 = s.getDeclaredConstructor(int.class);
        //下面这样会报错，因为不能使用私有的构造方法创建对象
        /*
        Object o1 = con2.newInstance(123);
        System.out.println(o1);
        */

        //但是在反射中，却可以使用私有的构造方法创建对象
        //方法就是采用暴力反射setAccessible(boolean flag)，当传入参数为true，可以取消访问检查
        con2.setAccessible(true);
        Object o2 = con2.newInstance(10);
        System.out.println(o2);

        //反射获取成员变量
        //getFields()方法会返回一个Field对象的数组
        //Field对象反映了由该Class对象表示的类的所有可访问的公共成员对象(public修饰的成员对象)
        //也就是说这个数组里的东西都是  代表公共成员变量
        Field[] f1 = s.getFields();
        for (Field f : f1){
            System.out.println(f);
        }
        //getDeclaredFields()方法也会返回一个Field对象的数组
        //Field对象反映了由该Class对象表示的类的所有的成员对象(所有成员对象)
        //也就是说这个数组里的东西都是  代表成员变量的对象
        Field[] f2 = s.getDeclaredFields();
        for (Field f: f2){
            System.out.println(f);
        }

        //反射中使用单个成员变量
        //首先需要创建构造方法对象
        Constructor<?> con3 = s.getConstructor();
        //通过构造方法对象创建对象
        //这里o3就相当于Student s里的s
        Object o3 = con3.newInstance();
        //获取指定成员变量对应的对象
        //获得public修饰的成员变量
        Field addressField = s.getField("address");
        //获得private修饰的成员变量
        Field idField = s.getDeclaredField("id");
        //给成员变量赋值
        //set(Object obj,Object value)方法是给obj对象的成员变量对象(ageField)赋值
        //private修饰的成员变量需要暴力反射
        idField.setAccessible(true);
        idField.set(o3,10);
        addressField.set(o3,"山西");
        System.out.println(o3);

        //反射获取成员方法
        //返回本类以及本类继承的类的公共方法
        Method[] m1 = s.getMethods();
        //返回本类中的所有方法
        Method[] m2 = s.getDeclaredMethods();
        for (Method m : m1){
            System.out.println(m);
        }
        System.out.println("---------------");
        for (Method m : m2){
            System.out.println(m);
        }

        //返回公共方法并使用
        Method m3 = s.getMethod("m1",null);
        Constructor<?> con4 = s.getConstructor();
        Object o4 = con4.newInstance();
        m3.invoke(o4);

        //返回私有方法并使用
        Method m4 = s.getDeclaredMethod("m2",null);
        //只要是私有的都要暴力反射
        m4.setAccessible(true);
        m4.invoke(o4);
    }
}
