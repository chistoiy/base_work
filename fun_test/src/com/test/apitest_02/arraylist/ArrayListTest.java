package com.test.apitest_02.arraylist;

/*数字缺点，一旦创建，程序运行期间长度不可发生改变，常见方式，新建一个大的数组，然后复制数据过去
 *因此使用Arraylist，拓展数组的操作方式
 * 因为ArrayList是泛型存储，泛型只能是引用类型
 * 基本类型则需要使用对应的包装类
 * byte Byte short Short  int Integer  long Long  float Float double Double char Character boolean Boolean
 * 使用时，需要如此指定：ArrayList<Person> alist = new ArrayList<>(); <>之间为该list泛型的类型
 *
 * */

import java.util.ArrayList;
import java.util.Random;

public class ArrayListTest {
    public static void main(String[] args) {
        Person[] array = new Person[3];

        Person one = new Person("小磊", 22);
        Person two = new Person("小光", 23);
        Person thr = new Person("小霍", 24);

        array[0] = one;
        array[1] = two;
        array[2] = thr;

        System.out.println(array[2].getName());
        System.out.println("==========");
        //ArrayList
        ArrayList<Person> alist = new ArrayList<>();
        System.out.println(alist);
        alist.add(one);
        alist.add(two);
        alist.add(thr);
        System.out.println(alist.get(0).getName());
        System.out.println("长度：" + alist.size());
        System.out.println("移除：" + alist.remove(0).getName());
        System.out.println("长度：" + alist.size());
        for (int i = 0; i < alist.size(); i++) {
            System.out.print(alist.get(i).getName());
        }
        System.out.println();
        ArrayList<Integer> intlist = new ArrayList<>();
        intlist.add(1);
        intlist.add(2);
        intlist.add(3);
        intlist.add(4);
        System.out.println(intlist);

        /*随机生成6个1~33的随机整数，添加到集合
         * */
        ArrayList<Integer> randomlist = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            randomlist.add(new Random().nextInt(33) + 1);
        }
        System.out.println(randomlist);


    }

    public static void printArrayList(ArrayList<String> list) {

    }
}
