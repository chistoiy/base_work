package com.test.extends_polymorphism_03.polymorphismTest;
/*多态
* 主要体现在：父类引用指向子类对象
*目的所在，每个类实例时，左侧的类型是统一，参数调用时，成员方法如果子类没有覆盖重写时，则去父类的，成员变量则从父类开始读取
*
* */


public class PolymorphismTest {
    public static void main(String[] args) {
        //父类引用指向子类对象
        Fu obj = new Zi();
        obj.method();
        obj.methodFu();
        System.out.println(obj.age);
        //如果想要使用obj的Zi类独有的方法，需要将obj向下转换
        //但有时，Fu类的继承者过多，向下转换可能会出错，则需要先使用instanceof 来判断一下对象是那个一类的实例
        if(obj instanceof Zi){
            Zi zi =(Zi) obj;
            zi.methodZi();
            System.out.println(zi.age);
        }
    }
}
