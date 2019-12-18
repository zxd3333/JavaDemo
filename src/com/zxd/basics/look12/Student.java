package com.zxd.basics.look12;

import java.io.Serializable;

public class Student implements Serializable {

    /*
       对于序列化的对象存储的文件，采用对象反序列化流读取数据，正常情况下可以读取到文件的内容
       但是如果修改了Student这个类的内容，那么就会读取失败并抛出异常
       例如在age字段前添加transient关键字，那么age字段不会被序列化
       也就是说age字段我们赋予的值是不会写入文件的，但是会有一个int类型的默认值被写入文件，即 0
    */

    /*
       序列化的类会声明一个serialVersionUID的字段，然后反序列化时候会获得这个字段
       修改了类的内容后，serialVersionUID就会发生变化，反序列的字段却还是以前的，所以会报错
       建议：可序列化的类显示声明serialVersionUID，尽可能使用private修饰，以免引起不必要的错误
    */

    private static final long serialVersionUID = 123456L;

    private int id;
    private String name;
    private transient int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ObjectStreamStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
