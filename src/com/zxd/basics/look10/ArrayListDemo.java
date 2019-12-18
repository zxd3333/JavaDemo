package com.zxd.basics.look10;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Scanner;

// ArrayList集合
// ArrayList是一个类，它实现了List接口，所以它也是有序的，有索引的，元素可以重复的
// ArrayList底层是数组，所以查询快，增删慢，线程不安全
public class ArrayListDemo {

    public static void main(String[] args) {

        // 通过学生管理系统了解ArrayList的使用
        ArrayList<Student> arrayList = new ArrayList<Student>();

        while(true){
            System.out.println("========欢迎进入学生管理系统========");
            System.out.println("1.查看所有学生");
            System.out.println("2.添加学生信息");
            System.out.println("3.删除学生信息");
            System.out.println("4.更新学生信息");
            System.out.println("5.退出系统");
            System.out.print("请输入你的选择:");

            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            switch(num){
                case 1:
                    findAll(arrayList);
                    break;
                case 2:
                    addOne(arrayList);
                    break;
                case 3:
                    delOne(arrayList);
                    break;
                case 4:
                    updateOne(arrayList);
                    break;
                case 5:
                    goOut();
            }
        }
    }

    public static void findAll(ArrayList<Student> array){
        if (array.size() == 0){
            System.out.println("系统中暂无学生，请先添加学生...");
        } else {
            System.out.println("学号\t姓名\t年龄");
            for (Student s : array){
                System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge());
            }
        }

    }
    public static void addOne(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);

        int id;
        int age;

        while (true){
            System.out.println("请输入学号：");
            id = sc.nextInt();
            boolean flag = checkId(array, id);
            if (flag){
                System.out.println("此ID已经存在！");
            } else {
                break;
            }
        }

        // 清除缓冲区的换行符
        // 使用nextInt()方法后，我们敲击回车符会留下换行符在缓冲区
        // 这样就造成nextLine()失效的问题
        // 所以这里再写一个nextLine()用来清理缓冲区的换行符
        sc.nextLine();

        System.out.println("请输入姓名：");
        String name = sc.nextLine();

        while (true){
            System.out.println("请输入年龄：");
            age = sc.nextInt();

            if (age <0 || age > 50){
                System.out.println("年龄区间不正确");
            } else {
                Student student = new Student(id,name,age);
                array.add(student);
                System.out.println("添加成功");
                break;
            }
        }
    }
    public static void delOne(ArrayList<Student> array){
        int id;
        if (array.size() == 0){
            System.out.println("系统中暂无学生，请先添加学生...");
        } else {
            System.out.println("请输入学号：");
            Scanner sc = new Scanner(System.in);
            id = sc.nextInt();

//            remove()方法是根据元素下标进行删除的
//            如果id很大(100)，下标很小(这个id是第一个插入进去的，那么下标就是0)
//            直接通过id进行删除( array.remove(id); )就会发生数组下标越界异常
//            所以下面这种方式是错误的
//            boolean flag = checkId(array, id);
//            if (flag){
//                break;
//            } else {
//                System.out.println("不存在学号为" + id + "的学生");
//            }

            // 设定一个下标，用来决定删除哪个下标的学生
            int index = -1;
            for (int i = 0; i < array.size(); i++){
                Student s = array.get(i);
                if (s.getId() == id){
                    index = i;
                    break;
                }
            }
            if (index == -1){
                System.out.println("不存在学号为" + id + "的学生");
            } else {
                array.remove(index);
                System.out.println("删除成功");
            }
        }
    }
    public static void updateOne(ArrayList<Student> array){
        if (array.size() == 0){
            System.out.println("系统中暂无学生，请先添加学生...");
        } else {
            int id;
            System.out.println("请输入学号：");
            Scanner sc = new Scanner(System.in);
            id = sc.nextInt();

            sc.nextLine();
            boolean flag = checkId(array, id);
            if (flag){
                System.out.println("请输入姓名：");
                String name = sc.nextLine();
                System.out.println("请输入年龄：");
                int age = sc.nextInt();

                Student student = new Student(id,name,age);
                for (int i = 0; i < array.size(); i++){
                    Student s = array.get(i);
                    if (s.getId() == id){
                        array.set(i,student);
                        break;
                    }
                }
                System.out.println("修改成功");
            } else {
                System.out.println("不存在学号为" + id + "的学生");
            }
        }
    }
    public static void goOut(){
        System.out.println("谢谢您的使用");
        System.exit(0);
    }

    public static boolean checkId(ArrayList<Student> array,int id){
        boolean flag = false;
        for (Student s : array){
            if (s.getId() == id){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
