package com.zxd.basics.look10;

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

        // 首先比较年龄
        // 如果年龄一样，就比较姓名，年龄不一样就返回年龄的差值
        // 如果最后返回的num2为0，则表示元素是重复的，就不会添加该元素
        // 如果num2大于0，则按顺序排列，如果小于0，就按倒序排列
        int num = this.age - person.age;
        int num2 = (num == 0) ? this.name.compareTo(person.name) : num;
        return num2;
    }
}
