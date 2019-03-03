package com.test.supply_12.relect_02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 *
 * 反射：框架设计的灵魂
 *   框架：半成品软件，可以在框架基础上进行软件开发，简化编码
 *   将类的各个组成部分封装成其他对象，->反射机制
 *
 *   Class对象功能：
 *      获取成员变量 主要是public修饰符，private需要单独额外指定
 *       Field[] getField();
 *       Field getField(String name);指定变量名
 *           获取该变量的值：Field.get(类对象)
 *           Field.set(类对象，值)，即根据Field在构造方法中参数类型传参即可
 *       Field[] getDeclaredField()
 *       Field getDeclaredEield(String name)
 *              想要读取private的变量，需要设置这个变量对象Field.setAccessible(true);暴力反射
 *      获取构造方法Constructor：
 *          Constructor<T> getConstructor(Class<?>... parameterTypes)
 *               返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法。
 *          newInstance(<T> t),用于创造对象的
 *             可以使用Class对象的newInstance()创造，效果一样
 *          同样构造器设置private的时候，一样需要这是setAccessible；
 *      获取成员方法：
 *          Method[] getMethods()
 *          Method ge他Method(String name,类<?>... parameterTypes)
 *              获取的方法对象使用invode(类对象)即可执行；
 *                  当方法是有参方法，需要在获取方法对象时传递参数类型的class
 *          Method[] getDeclaredMethods()
 *          Method getDeclareMethod(String name,类<?>... parameterTypes)
 *                  同样，当是private，还是要设置setAccessible；
 *
 *      获取类名
 *          String getName()
 *
 * */
public class RelectTest {
    public static void main(String[] args) throws Exception {
//获取成员变量
//getMemberParament();
//获取构造方法
//        getConstructor();
//获取成员方法
        getmemberMethod();
    }

    private static void getmemberMethod() throws Exception {
        Class personClass = Person.class;
        Method[] methods = personClass.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        Method method = personClass.getMethod("getAge");
        System.out.println(method.invoke(new Person("1", "2", 3)));
        Method method2 = personClass.getMethod("eat", String.class);//因为eat是有参方法， 所以需要传递参数类型的class
        method2.invoke(new Person("1", "2", 3), "lala");
    }

    private static void getConstructor() throws Exception {//获取构造方法
        Class personClass = Person.class;

        Constructor<Person> constructor = personClass.getConstructor(String.class, String.class, int.class);//获取构造器
        System.out.println(constructor);

        Object person = constructor.newInstance("构", "造", 33);
        System.out.println(person);
//可以使用Class对象的newInstance()创造，效果一样
        Object o = personClass.newInstance();
        System.out.println(o);

        System.out.println(personClass.getName());

    }

    static void getMemberParament() throws Exception {
        Class personClass = Person.class;
        for (Field field : personClass.getFields()) {
            System.out.println(field);
        }
//获取单个字段，及其值,设置值
        Field age = personClass.getField("age");
        //System.out.println(age);
        Person p = new Person("黑", "孙", 12);
        System.out.println(age.get(p));
        age.set(p, 14);
        System.out.println(p);

//        获取所有成员变量，不受修饰词影响
        Field[] fields = personClass.getDeclaredFields();
        Person a = new Person("小黑", "小吕", 20);
//        for (Field field : fields) {
//            System.out.println(field.get(p));
//        }
        Field ppp = personClass.getDeclaredField("name");
        ppp.setAccessible(true);
        System.out.println(ppp.get(p));
    }
}

class Person {
    private String name;
    public String nickname;
    public int age;

    public Person() {
    }

    public void eat(String s) {
        System.out.println(s);
    }

    public void eat() {
        System.out.println("eat eat eat!!!!");
    }

    public Person(String name, String nickname, int age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
}
