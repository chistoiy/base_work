package com.test.thread_08;

/*
 * lambda，
 *   函数式编程,
 *   使用前提，
 *      必须具有接口，且接口中有且只有一个抽象方法（此种接口成为函数式接口）
 *      必须具有上下文推断，也就是i方法的参数或局部变量类型必须为Lambda对应的接口类型
 *   格式：
 *       ()->{}  参数列表，->,覆盖重写方法的代码
 *       () 代表接口中抽象方法的参数列表，无参不写，多参逗号分隔
 *       -> 传递的意思，将参数传递给方法体
 *       {} 重写接口的抽象方法体
 *  lambda的省略格式：
 *      {参数列表}，参数列表的数据类型可以省略不写（）主要原因为可以推导出来
 *      {参数列表}括号里的参数如果只有一个，那么类型和()都可以省略
 *      {方法体}如果代码只有一行，无论是否有返回值，都可以省略（{}，return,分号）
 *                  方法体省略，则{}，return,分号需要一起省略
 *  java1.7之前，创建集合对象必须把前后泛型都写上
 *
 * */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lambda {
    public static void main(String[] args) {
//实现一个runnable然后线程启动
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("nihao");
            }
        };
        Thread t = new Thread(r);
        t.start();
//使用匿名内部类操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("nihao");
            }
        }).start();
//lambda方式
        new Thread(() -> {
            System.out.println("nihao");
        }).start();

//
        invoke(()->{
           System.out.println("lalalla");
       });


//
        Person[] arr = {new Person("春生",22),
                new Person("小斯",24),
                new Person("诺伊",23),
                        };

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        for (Person person : arr) {
            System.out.println(person.getName());
        }

        Arrays.sort(arr, ((Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        }));
        for (Person person : arr) {
            System.out.println(person.getName());
        }
//
        int sum = invoke2(new Calculate() {
            @Override
            public int method(int... nums) {
                int sum = 0;
                for (int num : nums) {
                    sum+=num;
                }
                return sum;
            }
        },1,2,3,4,5,6);

        System.out.println(sum);


        int ss =invoke2((int ... nums)->{
            int sums = 0;
            for (int num : nums) {
                sums+=num;
            }
            return sums;
        },1,2,3,4,5,6);

        System.out.println(ss);


    }

    static void invoke(Cook cook){
        cook.makeFood();
    }

    static int invoke2(Calculate c,int ... nums){
       return  c.method(nums);
    }
}

interface Cook {
    void makeFood();
}

class Person{
    private String name;
    private  int age;

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

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface Calculate{
    int method(int ... nums);
}
