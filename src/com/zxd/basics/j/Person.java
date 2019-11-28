package com.zxd.basics.j;

//TreeSetDemo定义的类
public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person person) {

        //如果年龄不一样，就返回差值
        //如果年龄一样，就比较姓名
        //最后返回值如果大于零，就是正向排序，反之逆向
        int num = this.age - person.age;
        int num2 = num == 0 ? this.name.compareTo(person.name) : num;
        return num2;
    }
}
