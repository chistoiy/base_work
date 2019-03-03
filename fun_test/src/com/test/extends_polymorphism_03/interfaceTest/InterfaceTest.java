package com.test.extends_polymorphism_03.interfaceTest;
/*
* 接口是多个类的公共规范，是一种引用数据类型，最主要的就是其中的抽象方法
*使用大驼峰命名规则
* 接口办函的内容
*   1.7：常量，抽象方法
*   1.8：默认方法，静态方法
*   1.9：私有方法
*
* 实现类如果没有全部重写接口类的所有抽象方法，则与抽象类的继承相似，该实现类只能修改成一个抽象类
* 接口类本身不能被实例使用，必须通过它的实现类们来调用
* */
public class InterfaceTest {
    public static void main(String[] args) {
        MyInterfaceAbstractImpl impl = new MyInterfaceAbstractImpl();
        impl.methodAbs();
        impl.methoddefault();
        MyInterfaceAbstract.methodstatic();
        System.out.println(MyInterfaceAbstract.AGE_OF_MY_DOG);
    }
}
