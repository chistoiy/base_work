package com.test.apitest_02;

/*
* StringBuilder维护了一个字符串缓冲区，可用于动态修改其中的字符
* public StringBuilder append() 添加任意类型数据的字符串形式，并返回当前自身；
*toString() ，返回一个字符串
* */

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = sb.append("as");
        System.out.println(sb);
        sb.append("kk");
        System.out.println(sb == sb2);//两者的地址是一致的，
        System.out.println(sb.toString());
    }
}
