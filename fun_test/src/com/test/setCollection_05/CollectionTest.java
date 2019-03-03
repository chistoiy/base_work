package com.test.setCollection_05;
/*
 * collection集合
 *   与数组区别在于，长度可变
 *       数组存储类型必须一致且均是基本类型，集和存储均为对象，且类型可以不一致；
 *   目标：会使用存储
 *           会遍历，读取
 *           掌握多种集合特性
 *
 *   Collection接口：
 *        定义的是所有单列集合中共性的方法，所有单列集合都可以使用的共性方法，但没有带索引的方法
 *        接口继承者有两个，List接口及set接口
 *           List接口：
 *               有序集合（存储与去除数据顺序相同），允许存储重复元素，有索引，可以使用for来循环遍历
 *               接口实现类：
 *                   Vector集合 ArrayList集合 LinkList集合
 *           set接口：
 *               不允许存储重复元素 无索引（无法被for遍历），
 *               接口实现类：
 *                  两个均为无序集合 TreeSet集合，HashSet集合（其继承者LinkedHashSet集合，有序的集合）
 * */
/*
 * collection 接口的共性方法：
 * public boolean add(E e) 将给定对象添加到当前集合中
 *  void clear()移除此 collection 中的所有元素（可选操作）。
 *  boolean remove(Object o)从此 collection 中移除指定元素的单个实例，如果存在的话（可选操作）。
 *  boolean contains(Object o)如果此 collection 包含指定的元素，则返回 true。
 *  boolean isEmpty()如果此 collection 不包含元素，则返回 true。
 *  int size()返回此 collection 中的元素数。
 *  Object[] toArray()返回包含此 collection 中所有元素的数组。
 * */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args) {
        //collectionT1(); //collection 的共性方法测试
        //集合的迭代器的使用,Iterator 迭代器是个接口，需要接口实现类
        iteratorT2();
        System.out.println("===========");
        advanceForT3();
    }

    static void collectionT1() {

        Collection<String> coll = new ArrayList<>();
        boolean b1 = coll.add("张三");
        System.out.println(b1);
        coll.add("q1");
        coll.add("w2");
        System.out.println("当前集合的内容：" + coll);
        coll.remove("张三");
        System.out.println("删除张三后的集合：" + coll);
        System.out.println("q1是否存在呢：" + coll.contains("q1"));
        System.out.println("当前集合的长度" + coll.size());
        System.out.println("集合是否为空：" + coll.isEmpty());
        coll.clear();
        System.out.println("清空集合,集合是否是空呢？" + coll.isEmpty());

    }

    static void iteratorT2() {
        Collection<String> coll = new ArrayList<>();
        coll.add("q1");
        coll.add("w2");
        coll.add("e3");
        System.out.println(coll.size());
        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    static void advanceForT3() {
        /*
         * jdk1.5之后的foreach，实现原理也是迭代器
         * 所有的单列集合都可以使用增强for，能且只能是用于遍历数组与集合，
         * 格式：
         *   for(集合/数组的数据类型 变量名： 集合名/数组名){
         *
         *       }
         * */
        //对数组使用的增强for循环
        // advanceFor_arr();

        ArrayList<String> list = new ArrayList<>();
        list.add("AA");
        list.add("B");
        list.add("CC");
        list.add("DD");

        for (String s : list) {
            System.out.println(s);
        }

    }

    static void advanceFor_arr() {
        int[] arr = {1, 2, 3, 4};
        for (int i : arr) {
            System.out.println(i);
        }
    }


}
