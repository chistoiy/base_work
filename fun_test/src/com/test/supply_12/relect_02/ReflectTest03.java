package com.test.supply_12.relect_02;

/*
* class对象功能获取方法的三种方式
*   Class.forName("全类名")，加载字节码文件进内存，返回ckass对象
*       用于配置文件，将类名定义在配置文件中，读取文件，加载类
*   类名.class,t通过类名的属性class获取
*       参数传递
*   对象.getClass()：
*       对象获取字节码
*   同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次，
*       无论通过哪一种方式得到的都是同一个类对象
* */

public class ReflectTest03 {
    public static void main(String[] args)throws Exception {

        //1
        Class cls = Class.forName("com.test.supply_12.relect_02.PersonObjectForReflct");
        System.out.println(cls);
//2
        Class cls2 = PersonObjectForReflct.class;
        System.out.println(cls2);

        //3
        PersonObjectForReflct p = new PersonObjectForReflct();
        Class cls3 = p.getClass();
        System.out.println(cls3);
    }
}
