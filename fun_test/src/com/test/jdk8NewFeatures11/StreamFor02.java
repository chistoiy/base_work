package com.test.jdk8NewFeatures11;

/*
 * java8新特性
 *   传统for对集合操作较为麻烦
 *   因此java1.8新增了stream.Stream(T)最常用的流接口，但不是函数式接口
 *
 *   stream是一个管道流，只能被使用一次，第一个stream流调用完毕方法后，数据就流转到下一个stream上，第一个stream就不能再调用方法了
 *
 *   获取一个流的常用方式：
 *       所有Collection集合都可以stream默认方法获取流
 *       stream接口静态方法of()可以获取数组对应的流
 *
 *    stream中的常用方法：
 *       void forEach(Consumer<? super T>action)
 *              其中需要的为Consumer的接口，因此可以直接写一个Lambda
 *      stream<T> filter(Predicate<? super T> pridicate)
 *              Predicate接口，根据数据判断返回一个boolean的值，当返回了true，filter就会将数据放于新的stream
 *      <R> Stream<R> map(Function<? super T, ? extends R> mapper);
 *              map：如果需要将流中的元素映射到另一个流中，可以使用 map 方法。
 *      long count()
 *          返回流中数据个数,终结方法
 *      Stream<T> limit(long maxSize);
 *          limit 方法可以对流进行截取，只取用前n个
 *              返回有效数量个到新流中
 *      Stream <T> skip(long count):
 *          skip跳过前面几个,超过流长度时，则返回一个空流
 *      static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 *          如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat
 * */

import java.util.*;
import java.util.stream.Stream;

public class StreamFor02 {
    public static void main(String[] args) {
//普通的for操作
//baseFor();

//        streamFor();
//流对象创建
        //streamCreate();
//stream的eachfor方法
//        eachFor( );
        //stream的filter方法
//        filterFor();
//map方法测试
        //   mapFor();
//        countFor();
//limitFor();
//        skipFor();
        //concatFor();
//实例测试
        test();

    }

    private static void test() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("李四光");
        arr.add("周三");
        arr.add("马克");
        arr.add("苏利");
        arr.add("邱触");
        Stream<String> stringStream = arr.stream().filter(name -> name.length() == 3).limit(3);

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("陈皮阿四");
        arr2.add("谢灵运");
        arr2.add("孙思邈");
        arr2.add("傲秋");
        arr2.add("张生");
        arr2.add("张白沫");
        arr2.add("苏果");
        arr2.add("张一秋");
        Stream<String> stringStream2 = arr2.stream().filter(name -> name.startsWith("张")).skip(2);
        Stream.concat(stringStream, stringStream2).map(( name) ->new Person(name)).forEach(person-> System.out.println(person));

    }

    private static void concatFor() {
        Stream<String> stream1 = Stream.of("张三", "张四", "王二", "麻子", "赵老二");
        Stream<String> stream2 = Stream.of("1", "2", "3", "4", "5");
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(name -> System.out.println(name));
    }

    private static void skipFor() {
        Stream<String> stream = Stream.of("张三", "张四", "王二", "麻子", "赵老二");
        Stream<String> skip = stream.skip(2L);
        skip.forEach(name -> System.out.println(name));
    }

    private static void limitFor() {
        Stream<String> stream = Stream.of("张三", "张四", "王二", "麻子", "赵老二");
        Stream<String> limit = stream.limit(7L);
        limit.forEach(name -> System.out.println(name));
    }

    private static void countFor() {
        Stream<String> stream = Stream.of("张三", "张四", "王二", "麻子", "赵老二");
        long count = stream.count();
        System.out.println(count);
    }

    private static void mapFor() {
        Stream<String> stream = Stream.of("1", "2", "3", "4", "5");
        Stream<Integer> str = stream.map((String s) -> {
            return Integer.parseInt(s);
        });
        str.forEach(name -> System.out.println(name));

    }

    private static void filterFor() {
        Stream<String> stream = Stream.of("张三", "张四", "王二", "麻子", "赵老二");
        Stream<String> str = stream.filter((String name) -> {
            return name.startsWith("张");
        });
        str.forEach(name -> System.out.println(name));
    }


    static void baseFor() {
        List<String> list = new ArrayList<>();
        list.add("孙超");
        list.add("白客");
        list.add("白百合");
        list.add("吕布");
        list.add("涨潮");

        List<String> listA = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                listA.add(s);
            }
        }
        List<String> listB = new ArrayList<>();
        for (String s : list) {
            if (s.length() == 3) {
                listB.add(s);
            }
        }
        for (String s : listB) {
            System.out.println(s);
        }

    }

    static void streamFor() {
        List<String> list = new ArrayList<>();
        list.add("孙超");
        list.add("白客");
        list.add("白百合");
        list.add("吕布");
        list.add("张潮");
        list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 2).forEach(name -> System.out.println(name));
    }

    private static void streamCreate() {
        Map<String, String> map = new HashMap<>();
        Set<String> keyMap = map.keySet();
        Stream<String> keymapStream = keyMap.stream();
        Collection<String> values = map.values();
        Stream<String> valuesStream = values.stream();
//liang
        Stream<Integer> streamInt = Stream.of(1, 2, 3, 4, 5);

        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> streamArrInt = Stream.of(arr);
    }

    private static void eachFor() {
        Stream<String> stream = Stream.of("张三", "李四", "王二", "麻子", "赵老二");
        stream.forEach((String name) -> {
            System.out.println(name);
        });
    }

}

class Person{
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
