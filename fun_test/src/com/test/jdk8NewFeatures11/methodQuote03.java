package com.test.jdk8NewFeatures11;

/*
 * 方法引用
 *  对象名引用成员方法
 *  类名称引用静态方法
 *  super引用成员方法
 *      引用调用父类的方法
 *      实验发现，引用父类使用super时，父类方法的参数位要和接口参数位一致才能保证变量传递正常。
 *  this引用成员方法
 *      与super类似，当this引用时，参数必须与接口参数一致
 *  类的构造器引用
 *      主要使用方式，接口定义参数后，同时返回一个类型，
 *      在lambad时返回一个new类型的对象，那么就可以使用这个类型::new 方式来引用
 *
 *
 * */

public class methodQuote03 {

    static void method(printable pr) {
        pr.prin("Hello");
    }


    public void method2(printable pr) {
        pr.prin("Hello");
    }

    public void method3() {
        System.out.println("this 调用成员方法");
    }

    public void method4(String s) {
        System.out.println("this 调用成员方法");
    }

    public void show() {
        method2((s) -> {
            this.method3();
        });
    }

    public void show2() {
        method2(this::method4);
    }

    public static void printName(String name, PersonBuilder pb) {
        PersonObject person = new PersonObject(name);
        System.out.println(person.getName());
    }

    public static int[] createArray(int length, ArrayBulder ab) {
        return ab.bulderArray(length);
    }
    public static void main(String[] args) {
        //1
        //对象名引用成员方法
//2
//        method((s)->{
//            ObjClass obj2 = new ObjClass();
//            obj2.upperprint(s);
//
//        });
        //对象名引用成员方法  advance
        //3.
        // ObjClass obj = new ObjClass();
        //method(obj::upperprint);

        //类名称引用静态方法
//        method((s)->{
//            ObjClass.upperprint2(s);
//        });
//        //advance
//        method(ObjClass::upperprint2);

        //super引用父类的方式
//        new Zi().show();
//        new Zi().show2();
        //new Zi().show3();


        //this本类成员方法
        new methodQuote03().show();
        new methodQuote03().show2();//使用引用方式，与super一样，调用方法的参数必须与接口参数一致

//new,构造方法引用方法
        printName("lala", (s) -> {
            System.out.println(s);
            return new PersonObject(s);
        });
        printName("lala", PersonObject::new);

        int [] a= createArray(10,(s)->{
            return new int[s];
        });
        System.out.println(a.length+"a");
        int[] b= createArray(10,int[]::new);
        System.out.println(b.length+"b");
    }
}

class ObjClass {
    void upperprint(String s) {
        System.out.println(s.toUpperCase());
    }

    static void upperprint2(String s) {
        System.out.println(s.toUpperCase());
    }
}

interface printable {
    void prin(String s);
}


class Fu {
    public void sayHello() {
        System.out.println("Hello ,Fu Class");
    }

    ;

    public void sayHello2(String s) {//super引用时使用，主要因为父类参数位需要跟接口参数为一致
        System.out.println("Hello ,Fu Class");
    }

    ;

}

class Zi extends Fu {

    @Override
    public void sayHello() {
        System.out.println("Hello, Zi Class");
    }

    public void sayHello2(String s) {
        System.out.println("Hello, Zi Class");
    }

    public void method(printable g, String s) {
        g.prin(s);
    }
//    public void show(){
//        method((s)->{
//            super.sayHello();
//        },"hello");
//    }
//    public void show2(){
//        method((s)->{
//            super.sayHello();
//        },"hello");
//    }

    public void show3() {
        method(super::sayHello2, "hello");

    }
}


//构造方法方式
interface PersonBuilder {
    PersonObject builderPerson(String name);
}

class PersonObject {
    @Override
    public String toString() {
        return "PersonObject{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonObject(String name) {
        this.name = name;
    }

    private String name;
}

//构造方法创建数组
interface ArrayBulder {
    int[] bulderArray(int length);
}
