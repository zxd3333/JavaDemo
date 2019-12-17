package com.zxd.basics.look06.second;

// 测试类
public class AnimalTest {

    public static void main(String[] args) {
        Animal dog = new Animal();

        // 通过set方法设置属性值
        dog.setName("小黑");
        dog.setAge(3);

        // 通过get方法获取属性值
        String name = dog.getName();
        int age = dog.getAge();

        // 输出name 和 age
        System.out.println(name + "," +age);

    }
}
