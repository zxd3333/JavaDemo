package com.zxd.m;

import java.io.*;

//对象序列化流
//序列化：将对象保存在磁盘中或者在网络中传输对象
//这种机制就是使用一个字节序列表示一个对象
//这个字节序列包括对象的类型，对象的数据和对象中存储的属性等信息
//字节序列写到文件之后，就相当于文件中持久保存了一个对象的信息
public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //对象序列化流，保存的是对象的信息
        //同时，一个对象想要被序列化，必须实现Serializable接口
        //Serializable这个接口没有任何方法，他只是一个标记接口
        //这个接口就是告诉我们我们实现这个接口的对象可以序列化了

        //写入数据
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\com\\zxd\\m\\f.txt",true));
        //由于保存的是对象的信息，所以需要创建一个对象：ObjectStreamStudent
        ObjectStreamStudent student = new ObjectStreamStudent(1,"照照",18);
        oos.writeObject(student);
        oos.close();

        //写入数据后打开f.txt发现出现了乱码
        //这是因为对象序列化流是基于二进制流的，在我们保存信息的时候，其实是将对象的相关信息转换成二进制存储在文件中
        //所以用文本编辑器打开时会出现乱码

        //对于序列化的对象存储的文件，采用对象反序列化流进行读取
        //读取数据
        //正常情况下可以读取到文件的内容
        //但是如果修改了ObjectStreamStudent这个类的内容，那么就会读取失败并抛出异常
        //例如在age字段前添加transient关键字，那么age字段不会被序列化
        //也就是说age字段我们赋予的值是不会写入文件的，但是会有一个int类型的默认值被写入文件，即 0

        //因为序列化的类会声明一个serialVersionUID的字段，然后反序列化时候会获得这个字段
        //修改了类的内容后，serialVersionUID就会发生变化，反序列的字段却还是以前的，所以会报错
        //建议：可序列化的类显示声明serialVersionUID，尽可能使用private修饰，以免引起不必要的错误
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\com\\zxd\\m\\f.txt"));
        Object o = ois.readObject();
        ObjectStreamStudent objectStreamStudent = (ObjectStreamStudent) o;
        System.out.println(objectStreamStudent);
        ois.close();

    }
}
