package com.zxd.m;

import java.io.Serializable;

//对象序列化流所使用的对象
public class ObjectStreamStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private transient int age;

    public ObjectStreamStudent() {
    }

    public ObjectStreamStudent(int id, String name, int age) {
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
