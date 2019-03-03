package com.test.basework01;

public class Class_Test01 {
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    String breed;
    int age;
    String color;
    public Class_Test01(String name){
        System.out.println("小狗的名字是"+name);
    }
    public void setAge(int age){
        age = age;
    }
    public int getAge(){
        System.out.println("小狗的年龄是"+age);
        return age;
    }
    void barking(){
        System.out.println("小狗汪汪叫");
    }
    void hungry(){
        System.out.println("小狗饿了");
    }
    void sleeping(){
        System.out.println("小狗睡觉中");
    }
    public static void main(String[] args){
        Class_Test01 mydog = new Class_Test01("panny");
        mydog.setAge(5);
        mydog.barking();
        mydog.sleeping();
        mydog.getAge();
        System.out.println("小狗的年龄"+mydog.age);
    }



}

class Person{
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
}


