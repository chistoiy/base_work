package com.test.apitest_02.arraylist;

import java.util.Arrays;
import java.util.Collections;
/* 与数组线管工具类，提供大量静态方法，实现数组常见功能
*public static String toString(数组)，将参数数组编程字符串
*public static void sort(数组),排序
* */
public class ArraysTest {
    public static void main(String[] args) {
        int [] intArray = {10,20,30};
        String intStr = Arrays.toString(intArray);
        System.out.println(intStr);
        Integer[] a = {4,2,3,4,5};
        Arrays.sort(a,Collections.reverseOrder());
        System.out.println(Arrays.toString(a));

    }
}
