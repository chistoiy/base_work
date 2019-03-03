package com.test.inerclass_outerclass_04.t01;
/*
* 内部类与外部类
* 1.成员内部类
*       放在一个类内，但不是在类方法内的类，成为成员内部类
*       成员内部类使用外部类的成员变量可以直接使用，
*       外部类使用内部类的方法时，除非在类内专门设置一个调用方法，使之能够运行，
*           同样可以使用这样的结构，外部类名.内部类名 对象名 = new 外部类名().new 内部类名();这样这个对象名则可以使用内部类的方法即对象
*
*       内部类与外部类的变量同名时，内部类变量可以用this来指定
*                                  外部类变量则为外部类名称.this.外部类变量名称
* 2.局部内部类
*       位于类的成员方法中的类，调用只能通过调用外部类的该方法来执行，并且需要该方法内一次性设置完毕相应的
*           实例与操作
*       局部内部类访问所在方法的局部变量，那么这个局部变量必须是有效final修饰的，java1.8开始，final可以不用写
*               主要原因，方法在栈里执行结束后就被抛出了，局部变量也会立刻消失，局部类被new时在堆里，在垃圾回收时消失，比方法存活时间长，局部变量实际上是被final修饰，存放在常量区的
* 2.1匿名内部类
*       即如果一个类只会被使用一次，如接口类定义完毕后，一般使用时需要先定义一个类来实现这个接口，然后重写该接口的方法
*           但使用匿名类时不需要单独写一个类来实现，而是使用格式：接口类 类对象名 = new 接口类(){ 重写接口类的方法}
*
* */


public class InnerClassTest {
    public static void main(String[] args) {
        System.out.println("使用间接方法调用");

        BodyClass body=new BodyClass();
        body.innermethod();

        System.out.println("使用直接调用的方式操作成员内部类的方法与变量");
        BodyClass.Innerclass dbody = new BodyClass().new Innerclass();
        dbody.innerMethod();
        System.out.println("打印成员内部类的变量："+dbody.inum);
        System.out.println("================");
        //开始局部内部类的部分
        body.outerMethod();
        System.out.println("================");
        //开始匿名内部类的部分
        MyInterface myinterfaceimpl = new MyInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名类覆盖重写接口类的method方法");
            }
        };
        myinterfaceimpl.method();

    }
}
