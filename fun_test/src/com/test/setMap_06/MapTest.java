package com.test.setMap_06;

import java.util.*;

/*
 * map集合
 *       map是存储键值对的，双列！
 *       key与value的数据类型可以不同
 *       元素的key不允许重复，value可以重复
 *       key与value一一对应
 *   常见实现类：
 *       HashMap<K,V>
 *           多线程操作，底层是哈希表，，无序
 *           java1.8- 数组+单向链表
 *           java1.8+ 数组+单向链表/红黑树
 *           同样具有继承类：
 *               LinkedHashMap 比hashmap多一个链表（用于保证元素顺序）
 *                  是一个有序集合，存储与读取顺序一致
 *       Hashtable<K,V>
 *           java1.0就出现了，底层是哈希表，单线程，键和值都不允许为null
 *           java1.2版本被Hashmap取代，但其子类Properties依旧在用是唯一和IO流相结合的集合
 *   常用方法：
 *      public V put(K key,V value);不重复则返回v，重复返回被覆盖的v
 *      public V get(K key);返回V,不存在返回null
 *      containsKey();
 *      containsValue;

 *      remove(K k)，存在返回v,不存在则返回null
 *       keySet(),取出所有的key至于set集合内
 *      entrySet(),返回此映射中包含的映射关系的 Set 视图
 *
 * */
public class MapTest {
    public static void main(String[] args) {
        //基础操作
        //t1();
        //t2();
        //t3();
        t4();
        HashtableT5();
    }

    static void t1() {
        Map<String, String> map = new HashMap<>();
        String v1 = map.put("李晨", "范冰冰");
        System.out.println(v1);
        String v2 = map.put("李晨", "孙意茹");
        System.out.println(v2);

        System.out.println(map);

        System.out.println(map.get("李晨"));

        System.out.println("是否存在key：李晨:" + map.containsKey("李晨"));
        System.out.println("是否存在value：孙意茹:" + map.containsValue("孙意茹"));

        //结合ketset遍历map
        System.out.println("结合ketset遍历map");
        System.out.println(map.keySet());
        Set<String> set = map.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(map.get(it.next()));
        }
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }

        //entry遍历
        System.out.println("结合entry遍历map");
        System.out.println(map.entrySet());
        Set<Map.Entry<String, String>> se = map.entrySet();
        for (Map.Entry<String, String> entry : se) {
            entry.getValue();
            String value = entry.getValue();
            String key = entry.getKey();
            System.out.println(key + ":" + value);
        }
    }

    static void t2() {
        HashMap<String, Person> map = new HashMap<>();
        map.put("北京", new Person("张三", 21));
        map.put("南京", new Person("里斯", 20));
        map.put("四川", new Person("王武", 19));
        map.put("河南", new Person("刘峰", 18));
        map.put("湖北", new Person("刘峰", 18));

        System.out.println(map.entrySet());

    }

    static void t3() {
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person("张三", 21), "北京");
        map.put(new Person("里斯", 20), "南京");
        map.put(new Person("王武", 19), "四川");
        map.put(new Person("刘峰", 18), "河南");
        map.put(new Person("刘峰", 18), "河南");
        System.out.println(map.entrySet());

    }
    static void t4(){

        HashMap<String ,String> map = new HashMap<>();

        map.put("A","a");
        map.put("B","b");
        map.put("C","c");
        map.put("D","d");

        System.out.println(map);

        HashMap<String ,String> map1 = new LinkedHashMap<>();

        map1.put("A","a");
        map1.put("B","b");
        map1.put("C","c");
        map1.put("D","d");

        System.out.println(map1);

    }

    static void HashtableT5(){
        Map<String,String> map = new Hashtable<>();

        map.put("A","a");
//        map.put("B",null);//不允许key与value为null
        System.out.println(map);

    }
}
