package com.test.setCollection_05.collectionsTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
* collections是collection集合工具类
* public static <T> boolean addAll(Collection<T>,c T ... elements),往集合添加元素
* public static void shuffle(List<?> list) 打乱集合
* public static <T> sort(List<T>,list),排序,默认升序
*       只能操作list集合，对set集合无法操作
*       非int和string类型排序，需要继承Comparable，然后重写compararto方法
*               compareTo内，this-o.参数为升序
* public static <T> sort(List<T>,list,Comparator<? super T>),排序
*               与上面的区别在于，此方法使用的Comparator是相当于找了一个第三方标准排序
* */
public class CollectionsTest {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"a","b","c","d");
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        ArrayList<Person> list2 = new ArrayList<>();
        Person p1 = new Person("小黑",19);
        Person p2 = new Person("小w",13);
        Person p3 = new Person("小孙",12);
        list2.add(p1);
        list2.add(p2);
        list2.add(p3);
        Collections.sort(list2);
        System.out.println(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        Collections.sort(list3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//降序
            }
        });
        System.out.println(list3);

        Collections.sort(list2, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -o2.getAge()+o1.getAge();//升序
            }
        });
        System.out.println(list2);

    }
}
