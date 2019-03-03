package com.test.fileOperate_09;

/*
 * 序列化与反序列化
 *   使用字节保存对象
 *   ObjectOutputStream对象序列化
 *       序列化时因为类实现了 Serializable接口后，在序列化时，编译器会给class文件一个序列号，这个序列号用于保证class文件的统一性，即用于反序列化时使用原本的class来解析
 *          因此在序列化后，如果修改了class文件其序列号与之前的不一样，则反序列化失败
 *
 *   ObjectInputStream对象反序列化
 *       读出来对象 readObject()
 *               一次性将流中所有的对象读取出来，存在一个list内
 *               此方法会报ClassNotFoundException，需要类实现Serializable接口（此时编译器javac会给这个class文件一个序列号），同时throws这个异常
 *               同时，需要存在类的class文件，
 *
 *
 *    在序列化对象时，类需要实现Serializable接口
 *   Exception in thread "main" java.io.NotSerializableException: com.test.fileOperate_09.Person
 *
 *   transient关键字：
 *      瞬态关键字
 *      被此关键字修饰的成员变量同样不能被序列化,
 *      但是安全起见，序列化对象时，不想被序列化的参数可以使用此关键字修饰
 *    static：
 *      静态优先于非静态加载到内存中（有限对象进入内存中）
 *      被static修饰的成员变量不能被序列化，序列化都是对象
 *
 *   序列号的变动：
 *      因为序列化对象的类实现了Serialize接口，那么每次修改了class文件后，都会重新生成一个序列号
 *          个别时候需要序列号不变，则可以手动指定
 *              序列化类定义类参数：private static final long serialVersionUID= 42L;
 * 打印流：
 *      PrintStream
 *      只负责数据的输出，不负责数据读取
 *      不会抛出IOExecption
 *      特有方法
 *          print,println等，输出任意类型的值
 *      构造方法：
 *          PrintStream(File file),输出目的为文件
 *          PrintStream(OutputStream out),输出字节流文件
 *      继承自父类OutputStream的方法
 *          使用父类的write方法写数据时，查看数据会查看编码表
 *          使用自己的print/println则原样输出
 *
 *      system.setOut(PrintStream ps)改变输出语句的目的地改为参数中传递打印流目的地
 *          重新分配标准输出流,原本在控制台的变为输出到ps的输出位置
 *
 *
 *
 * */

import java.io.*;
import java.util.ArrayList;

public class SerializeUnserialize07 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        serialize();
        unserialize();

        serializeTest();

        printStream();
    }

    private static void printStream() throws IOException {
        PrintStream ps = new PrintStream("print.txt");

        ps.print("nihao");
        ps.close();

        PrintStream ps2 = new PrintStream("打印流目的地.txt");

        ps2.print("nihao");
        System.setOut(ps2);
        System.out.println("打印位置变化了");
        ps2.close();

    }

    private static void serializeTest() throws IOException,ClassNotFoundException{
        ArrayList<Person> list = new ArrayList<>();

       list.add(new Person("小黑",12));
       list.add(new Person("小白",14));
       list.add(new Person("小绿",15));
       list.add(new Person("小紫",16));

       ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream("serializeTest.txt"));
//        for (Person person : list) {
//            oops.writeObject(person);
//        }
        oops.writeObject(list);
        oops.close();



        ObjectInputStream oips = new ObjectInputStream(new FileInputStream("serializeTest.txt"));
        Object o =oips.readObject();

        ArrayList<Person> li =(ArrayList<Person>)o;
        for (Person person : li) {
            System.out.println(person);
        }
        oips.close();





    }

    private static void unserialize() throws IOException, ClassNotFoundException {
        Person p = null;

        ObjectInputStream ooip = new ObjectInputStream(new FileInputStream("serialize.txt"));
        p = (Person) ooip.readObject();
        ooip.close();
        System.out.println(p.getName()+":"+p.getAge());


    }

    private static void serialize() throws IOException, ClassNotFoundException {
        Person p = new Person("小美", 12);
        FileOutputStream ops = new FileOutputStream("serialize.txt");
        ObjectOutputStream oops = new ObjectOutputStream(ops);
        oops.writeObject(p);
        oops.close();
        ops.close();
    }


}

class Person implements Serializable {
    //private static final long serialVersionUID= 42L;
    /*
     * Exception in thread "main" java.io.NotSerializableException: com.test.fileOperate_09.Person
     * */
    private String name;
    private transient int age;

    public Person() {
    }

    @Override
    public String toString() {
        return
                "name='" + name
                ;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
