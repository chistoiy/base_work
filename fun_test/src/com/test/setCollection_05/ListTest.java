package com.test.setCollection_05;

/*
 * List接口继承自collection接口
 *   特点：有序集合，有索引
 *           允许存储重复元素
 *   带索引的方法（特有）：
 *       add(int index,E e),按照索引添加元素
 *      public element remove(int index) 按照索引移除，返回删除的元素
 *      public element set(int index , E element)替换指定位置的元素，返回被替换的元素
 *       public element get(int index),按照指定索引获取
 *
 *    实现类集合：
 *       ArrayList，多线程操作，底层是一个数组[],操作原理依旧是添加内容时，先新建数组，然后复制数据，添加数据；
 *               查询快，增删慢
 *       LinkedList，多线程操作，使用链表实现的
 *               查询慢，增删方便，大量头尾节点操作方法，其特有方法不能使用多态
 *               addFirst(E e);
 *               addLast(E e);
 *               push(E e),压栈,头插法
 *               getFirst(),获取第一个元素
 *               getLast(),获取最后一个元素
 *               removeFirst(),移除并返回此列表第一个元素
 *               removeLast()，移除并返回最后一个元素
 *               pop()，移除并返回最后一个元素,头删法
 *               isEmpty();
 *               clear();清空集合
 *
 *        Vector java1.1就已经出现了，单线程操作，比较慢；1.2版本后更新了大量方法
 *              早期没有迭代器，使用静态方法
 *                  hasMoreElements()
 *                  nextElements()
 *              现在版本有迭代器，则使用迭代器操作即可
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        System.out.println("List测试");
//       listTest();
        linkedListTest();
    }

    static void listTest() {
        /*
         * list操作需要注意索引越界
         * */
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }

        list.add(2, "E");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.set(2, "Z");
        System.out.println(list);

        System.out.println(list.get(2));

    }

    static void linkedListTest() {
        LinkedList<String> linked = new LinkedList<>();

        linked.add("A");
        linked.add("B");
        linked.add("C");
        linked.add("D");
        System.out.println(linked);

        System.out.println(linked.getFirst());

        linked.push("E");
        System.out.println(linked);

        System.out.println(linked.pop());
        System.out.println(linked);


    }
}
