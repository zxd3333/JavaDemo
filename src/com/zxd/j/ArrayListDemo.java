package com.zxd.j;

import java.util.ArrayList;
import java.util.Scanner;

//ArrayList的使用
//ArrayList是一个类，实现了List接口，所以是有序的，元素可以重复
//它的底层是数组
public class ArrayListDemo {

    //通过学生管理系统了解ArrayList的使用
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<Student>();
        while(true) {
            System.out.println("------WelCome To Student Manager System------");
            System.out.println("1.添加学生");
            System.out.println("2.查看学生");
            System.out.println("3.修改学生");
            System.out.println("4.删除学生");
            System.out.println("5.退出系统");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();

            switch (index){
                case 1:
                    addStudent(arrayList);
                    break;
                case 2:
                    findStudent(arrayList);
                    break;
                case 3:
                    updateStudent(arrayList);
                    break;
                case 4:
                    delStudent(arrayList);
                    break;
                case 5:
                    System.out.println("谢谢使用");
                    System.exit(0);

            }
        }
    }

    public static void addStudent(ArrayList<Student> arrayList){
        Scanner sc = new Scanner(System.in);
        int id;

    }
    public static void findStudent(ArrayList<Student> arrayList){

    }
    public static void updateStudent(ArrayList<Student> arrayList){

    }
    public static void delStudent(ArrayList<Student> arrayList){

    }
}
