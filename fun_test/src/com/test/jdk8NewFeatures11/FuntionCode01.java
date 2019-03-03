package com.test.jdk8NewFeatures11;

/*
 *
 * 函数式接口：
 *   有且只有一个抽象方法（其他方法一样可以有）的接口，能够使用Lambda
 *   @FunctionalInterface注解，放置于接口之上，用于检测接口是否时函数式接口，
 *       是：编译成功
 *       否：编译失败（接口中没有抽象方法或个数多于一个）
 *   lambda是匿名内部类的形式，但是在编译时不会生成专有的class文件
 *   lambda是延迟执行的
 *  日志：
 *       记录程序运行情况，便于优化监控
 *       使用接口+lambda后，先判断条件，再处理内容
 *  返回值是一个函数时接口对象类型的，可以使用lambda
 *
 *  常用函数时接口
 *      supllier接口，接口定义为泛型，并且抽象方法get返回的也是同样的泛型
 *      consumer接口，消费性接口，泛型指定为特定类型，抽象方法accept()就可以处理相应类型数据
 *              默认方法：andThen(),连接两个consumer接口，然后对数据进行处理
 *      preficate接口：判断某种类型的数据的某些属性是否满足条件，返回boolean
 *              抽象方法：test(T t)
 *              默认方法：
 *                  and ,与consumer的andthen使用方式类似,功能是对两接口返回值进行and后返回结果
 *                  or，与and方法类似，功能是对接口返回值进行or后再返回
 *                  ！对返回值取反，等价于 接口对象.negate().test(参数)
 *
 *      function接口，根据一个类型的数据的到另一个类型的数据，前者为前置条件，后者为后置条件
 *          抽象方法：
 *              R apply(T t),根据类型T的参数获取类型R的结果，如将String的整数转Integer的整数
 *          默认方法
 *              andThen,将上一步return的值当作参数来处理
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuntionCode01 {

    private static void log(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {

        FuntioninterfaceTest(() -> System.out.println("Lambda方式处理"));

        String a = "AA";
        String b = "BB";
        String c = "CC";
        LoggerT2(2, () -> {
            //System.out.println("测试，不满足条件时是否执行到此处");
            return a + b + c;
        });

        startThread(() -> System.out.println(Thread.currentThread().getName() + ":start"));

        String[] arr = {"aaa", "bbb", "ccc"};

        Arrays.sort(arr, getComparatorT3());
        System.out.println(Arrays.toString(arr));

        System.out.println("supplier");
        //Supplier接口
        String sup = supplierTest(() -> {
            return "nihao";
        });
        System.out.println(sup);
        int[] iarray = {1, 2, 3};
        int maxNum = supplierTest2(() -> {
            int max = iarray[0];
            for (int i : iarray) {
                if (max <= i) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(maxNum);

        System.out.println("consumer");
        consumerTest("消费类型接口测试", (String name) -> {
            System.out.println(name);
        });
        consumerTest("消费类型接口测试", (String name) -> {
            String reName = new StringBuilder(name).reverse().toString();
            System.out.println(reName);
        });
        consumerTest2("andThen测试", (name) -> {
            System.out.println(name.toUpperCase());
        }, (name) -> {
            System.out.println(name.toLowerCase());
        });
        consumerTest3("andThen测试", (name) -> {
            System.out.println(name.toUpperCase());
        }, (name) -> {
            System.out.println(name.toLowerCase());
        });
        String[] sarr = {"刘禹锡,男", "苏小小,女", "李白,男"};
        stringConvert(sarr, (msg) -> {
            String name = msg.split(",")[0];
            System.out.print("姓名：" + name);
        }, (msg) -> {
            String sex = msg.split(",")[1];
            System.out.println(",性别：" + sex);
        });

        System.out.println("preficate");
        boolean pre = preficateTest("类型判断", (s) -> {
            return s instanceof String;
        });
        System.out.println(pre);
        boolean pre2 = preficateTest("春眠不觉晓,处处闻啼鸟", (s) -> {
            return s.contains(",");
        });
        System.out.println(pre2);
        boolean pre3 = preficateTest2("春眠不觉晓,处处闻啼鸟", (s) -> {
            return s.length() > 10;
        }, (s) -> {
            return s.contains(",");
        });
        System.out.println("pre3:" + pre3);
        String[] array = {"刘禹锡,男", "苏小小,女", "李白,男", "王维,男"};
        ArrayList<String> alist = preficateTest3(array, (s) -> {
            return s.split(",")[1].equals("男");
        }, (s -> {
            return s.split(",")[0].length() == 2;
        }));
        System.out.println(alist);

        functionTest("123", (s) -> {
            return Integer.parseInt(s);
        });
        functionTest2("123", (s) -> {
            return Integer.parseInt(s) + 50;
        }, (s) -> {
            return s.toString();
        });
       int i =  functionTest3("孙仲谋,22",(s)->{
            return s.split(",")[1];
        },(s)-> Integer.parseInt(s),(s)->{return s+100;});
        System.out.println(i);
    }


    static void FuntioninterfaceTest(FuntionInterface fi) {
        fi.method();
    }

    static void LoggerT1() {//当传递的等级不是1时，实际上不会有结果，但是字符串已经拼接，这也就导致了性能浪费
        String a = "AA";
        String b = "BB";
        String c = "CC";
        log(1, a + b + c);
    }

    static void LoggerT2(int level, LoggerInterface li) {
        if (level == 1) {
            System.out.println(li.method());
        }
    }

    static void startThread(Runnable run) {
        new Thread(run).start();
    }

    //返回值为接口
    static Comparator<String> getComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        };
    }

    static Comparator<String> getComparatorT2() {
        return (String o1, String o2) -> {
            return o2.length() - o1.length();
        };
    }

    static Comparator<String> getComparatorT3() {
        return (o1, o2) -> o2.length() - o1.length();
    }

    static String supplierTest(Supplier<String> s) {
        return s.get();
    }

    static Integer supplierTest2(Supplier<Integer> s) {
        return s.get();
    }

    static void consumerTest(String name, Consumer<String> c) {
        c.accept(name);
    }

    static void consumerTest2(String name, Consumer<String> c1, Consumer<String> c2) {//不使用andThen操作
        c1.accept(name);
        c2.accept(name);
    }

    static void consumerTest3(String name, Consumer<String> c1, Consumer<String> c2) {//使用andThen操作
        c1.andThen(c2).accept(name);
    }

    static void stringConvert(String[] arr, Consumer<String> c1, Consumer<String> c2) {
        for (String msg : arr) {
            c1.andThen(c2).accept(msg);
        }

    }

    static boolean preficateTest(String s, Predicate<String> p) {
        return p.test(s);
    }

    static boolean preficateTest2(String s, Predicate<String> p1, Predicate<String> p2) {//and方法测试
        return p1.and(p2).test(s);
    }

    private static ArrayList<String> preficateTest3(String[] array, Predicate<String> p1, Predicate<String> p2) {

        ArrayList<String> list = new ArrayList<>();
        for (String s : array) {
            boolean b = p1.and(p2).test(s);
            if (b) {
                list.add(s);
            }
        }
        return list;
    }

    static void functionTest(String st, Function<String, Integer> f) {
        Integer in = f.apply(st);
        System.out.println(in);
    }

    static void functionTest2(String st, Function<String, Integer> f1, Function<Integer, String> f2) {
        String in = f1.andThen(f2).apply(st);
        System.out.println(in);
    }

    static int functionTest3(String st, Function<String, String> f1, Function<String, Integer> f2, Function<Integer, Integer> f3) {
        Integer in = f1.andThen(f2).andThen(f3).apply(st);
        System.out.println(in);
        return in;
    }


}

class FuntionInterfaceImpl implements FuntionInterface {

    @Override
    public void method() {

    }
}

@FunctionalInterface
interface FuntionInterface {//函数式接口

    abstract void method();
}

@FunctionalInterface
interface LoggerInterface {
    abstract String method();
}
