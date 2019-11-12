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

    //添加学生信息
    public static void addStudent(ArrayList<Student> arrayList){
        Scanner sc = new Scanner(System.in);

        int id;
        int age;

        while(true) {
            System.out.println("请输入学号：");
            id = sc.nextInt();

            boolean flag = checkId(arrayList,id);
            if (flag){
                System.out.println("该学号已经存在,请重新注册...");
            }else {
                break;
            }
        }

        //清除缓冲区的换行符
        //使用nextInt()方法后，我们敲击回车符会留下换行符在缓冲区
        //这样就造成nextLine()失效的问题
        //所以这里再写一个nextLine()用来清理缓冲区的换行符
        sc.nextLine();

        System.out.println("请输入名字：");
        String name = sc.nextLine();

        while(true) {
            System.out.println("请输入年龄：");
            age = sc.nextInt();

            boolean ageFlag = true;
            if (age < 0 || age > 50) {
                ageFlag = false;
            }
            if (ageFlag) {
                Student student = new Student(id, name, age);
                arrayList.add(student);
                System.out.println("添加成功");
                break;
            } else {
                System.out.println("年龄区间不正确,重新输入年龄...");
            }
        }
    }

    //查找所有学生
    public static void findStudent(ArrayList<Student> arrayList){

        if (arrayList.size() == 0){
            System.out.println("还没有录入学生信息");
        }else {
            System.out.println("学号\t姓名\t年龄");
            for (Student s : arrayList) {
                System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge());
            }
        }
    }

    //更新学生信息
    public static void updateStudent(ArrayList<Student> arrayList){

        if (arrayList.size() == 0){
            System.out.println("还没有录入学生信息");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.println("输入要修改的学生的学号：");
            int id = sc.nextInt();

            sc.nextLine();

            boolean flag = checkId(arrayList,id);

            if (flag) {
                System.out.println("输入新的名字：");
                String name = sc.nextLine();

                System.out.println("请输入新的年龄：");
                int age = sc.nextInt();

                Student s = new Student();
                s.setId(id);
                s.setName(name);
                s.setAge(age);

                for (int i = 0; i < arrayList.size(); i++){
                    Student student = arrayList.get(i);
                    if (student.getId() == id){
                        arrayList.set(i,s);
                        break;
                    }
                }
                System.out.println("修改成功");
            } else {
                System.out.println("不存在学号为" + id + "的学生");
            }
        }

    }
    public static void delStudent(ArrayList<Student> arrayList){
        if (arrayList.size() == 0){
            System.out.println("还没有录入学生信息");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要删除的学生的学号：");
            int id = sc.nextInt();

            //用来确定删除哪个学号的学生
            int index = -1;
            for (int i = 0; i < arrayList.size(); i++) {
                Student s = arrayList.get(i);
                if (s.getId() == id) {
                    index = i;
                    break;
                }
            }
            if (index == -1){
                System.out.println("不存在学号为" + id + "的学生");
            }else {
                arrayList.remove(index);
                System.out.println("删除成功");
            }
        }
    }

    public static boolean checkId(ArrayList<Student> arrayList, int id){
        boolean flag = false;
        for (Student s : arrayList){
            if (s.getId() == id){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
