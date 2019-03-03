package com.test.setCollection_05.setTest;

/*
 * set接口同样继承自collection接口
 *   不支持重复元素存储，无索引
 *   在调用add方法时，会调用元素的hashCode()和equals方法，以方便存储与去重
 *   实现类：
 *       HashSet  使用哈希表结构操作，多线程操作,
 *           无序，查询快
 *           哈希值：十进制整数，系统随机给出（一个逻辑地址，不是实际上数据存储的物理地址）
 *               hashCode()来获取
 *               java1.8以前哈希表=数组+链表
 *               java1.8+：哈希表=数组+链表
 *                           哈希表=数组+红黑树（提高查询速度）
 *
 *           实现过程是：计算元素的哈希值，然后将同一哈希值的元素使用链表（当链表长度超过8位时，链表转为红黑树）连接在一起（哈希冲突也一样操作）
 *                       哈希冲突：元素值不同，哈希值相同
 *           继承类;
 *               LinkedHashSet 与hashset区别在于其中多使用了一个双向链表，用于记录元素存储顺序，保证元素有序
 * */

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {

//        hashSetTest();

//        String i = "ass";
//        System.out.println(i.hashCode());

        //自定义元素的hashCode和equals方法，
//        System.out.println("姓名和年龄一样视为同一人");

//        hashSetTest2();

        linkedHashSetTest();


    }

    static void hashSetTest() {
        Set<String> set = new HashSet<>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String s : set) {
            System.out.println(s);
        }
    }

    static void hashSetTest2() {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("小黑", 19);
        Person p2 = new Person("小黑", 19);
        Person p3 = new Person("小黑", 18);
        set.add(p1);
        set.add(p2);
        set.add(p3);

        for (Person person : set) {
            System.out.println(person.getName() + person.getAge());
        }

    }

    static void linkedHashSetTest() {

        HashSet<String> set = new HashSet<>();
        set.add("www");
        set.add("abc");
        set.add("abc");
        set.add("lalalla");
        System.out.println(set);
        HashSet<String> linked = new LinkedHashSet<>();
        linked.add("www");
        linked.add("abc");
        linked.add("abc");
        linked.add("lalalla");
        System.out.println(linked);

    }
}
