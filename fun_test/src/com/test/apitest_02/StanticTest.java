package com.test.apitest_02;

/*
 * static修饰的成员方法，只能访问静态变量，这一过程主要是内存中先存放的静态内容，则静态方法无法获知非静态变量
 *同时，静态方法中不能使用this
 * 静态代码块：
 * 在类中设置一个static{ 。。}在{}之间写入代码，这一段代码只会在这个类第一次实例化时执行，即二次实例也不会被执行，主要用于一次性对静态成员变量进行赋值
 * */


class Pereson{
int num;
static int numstatic;

static{
    numstatic=23;
}

public void t1(){
    System.out.println(num);
    System.out.println(numstatic);
}
public static void t2(){
    System.out.println(numstatic);
//    System.out.println(num);
}
}

public class StanticTest {


    public static void main(String[] args) {

    }
}
