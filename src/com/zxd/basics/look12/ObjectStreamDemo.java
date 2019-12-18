package com.zxd.basics.look12;

import com.zxd.basics.m.ObjectStreamStudent;

import java.io.*;

// 对象序列化流
/*
   序列化：将对象保存在磁盘中或者在网络中传输对象
          这种机制就是使用一个字节序列表示一个对象
          这个字节序列包括对象的类型，对象的数据和对象中存储的属性等信息
          字节序列写到文件之后，就相当于文件中持久保存了一个对象的信息
*/
public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 对象序列化流，保存的是对象的信息，一个对象想要被序列化，必须实现Serializable接口
        // Serializable这个接口没有任何方法，只是一个标记接口，就是告诉我们我们实现这个接口的对象可以序列化

        // 写入数据
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\zxd\\basics\\look12\\StaticFile\\f.txt",true));
        // 由于保存的是对象的信息，所以需要创建一个对象：Student
        Student student = new Student(1,"小黑",18);
        oos.writeObject(student);
        oos.close();

        /*
          写入数据后打开f.txt发现出现了乱码
          这是因为对象序列化流是基于二进制流的，在我们保存信息的时候，其实是将对象的相关信息转换成二进制存储在文件中
          所以用文本编辑器打开时会出现乱码
        */

        // 对于序列化的对象存储的文件，采用对象反序列化流读取数据
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\zxd\\basics\\look12\\StaticFile\\f.txt"));
        Object o = ois.readObject();
        Student Student = (Student) o;
        System.out.println(Student);
        ois.close();
    }
}
