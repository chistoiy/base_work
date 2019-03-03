package com.test.apitest_02;
/*
* 包装类；基本数据类型有八种，均有各自的包装类
* int Intger double Double
*
* 包装与拆包;
*       包装使用构造方法
*           Interger(int value) 构造一个新分配的 Integer 对象，它表示指定的 int 值。
*           Interger(String s)构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值。
*       拆箱：
*           将数据取出来
*               intValue() 以 int 类型返回该 Integer 的值。
*
*     java1.5之后包装与拆包自动处理
*              包 Integer i = 1;即可
*              拆 i = i +2; /不需要单独使用intValue()处理，处理完毕后再次包装为Integer
*              如ArrayList本身无法存储int，实际上在存储时是自动包装为Integer类型的
*      三种转换int转String
*            String p = String.valueof(d)
*            String p = Integer.toString(d)
*            String p = d+""
*      String转int：
*             int k =Integer.parseInt(d);
* */

public class PackingClass {
    public static void main(String[] args) {
        Integer s = new Integer("1");
        System.out.println(s);
        System.out.println(s.intValue());

        String d = "1";

        System.out.println(d instanceof String);
        int k =Integer.parseInt(d);
        System.out.println(k+1);

    }
}
