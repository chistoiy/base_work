package com.test.extends_polymorphism_03.interfaceTest;
/*
* 接口的抽象方法只能由public abstract 修饰（可以不写，但不能是其他修饰），
* 使用接口类的实现类必须全部覆盖重写接口内的抽象方法
* java 1.8新添加了接口类中可以添加默认方法，目的在于解决，如果一个接口已经在用，但还需要对接口类添加新的方法，又无法去修改该接口的实现类
*   所以使用defualt来定义方法，该方法不需要实现类来重写覆盖，并且会自动被实现类继承下去
*   同样的是，默认方法一样可以被实现类有选择地覆盖重写
*
* java 1.8允许接口中添加静态方法，将abstract或default换成static，然后添加方法体即可，但是该静态方法不能通过实现类来调用接口类的静态方法
*     需要使用接口类名称来调用这个静态方法
* java 1.9 接口类设置私有方法，用于解决接口类内出现多次重复的代码，同时不应该被实现类来使用
*   普通私有方法，解决多个默认方法之间重复代码问题
*       private 返回值类型 方法名称（参数列别）{}
*   静态私有方法，解决多个静态方法之间重复代码问题
*      private static 返回值类型 方法名称（参数列别）{}
*
* 接口类也允许定义成员变量，但必须使用public static final修饰，实际效果接近一般的常量定义
*       同时在一开始定义时必须赋值，一旦赋值即不可再修改，使用时为接口类名.该变量名
*
*
* 注意;
* 接口不存在静态代码块static{。。。} 同样不存在构造方法
*
*接口类继承接口类，父接口的抽象方法重复不影响，
*   默认方法重复需要覆盖重写该默认方法
* */
public interface MyInterfaceAbstract {

    public static final int AGE_OF_MY_DOG = 10;

    public abstract void methodAbs();

    public default void methoddefault(){
        System.out.println("接口类的默认方法");

    }
    public static void methodstatic(){
        System.out.println("接口类的静态方法");

    }

    /*  java1.9+ 环境支持
    private void methodPrivate(){
        System.out.println("接口执行一次普通私有方法");
    }
    private static void methodStaticPrivate(){
        System.out.println("接口执行一次静态私有方法");
    }

    public default void methoddefault(){
        System.out.println("接口类的默认方法");
        methodPrivate();
    }
    public static void methodstatic(){
        System.out.println("接口类的静态方法");
        methodStaticPrivate();
    }
    */

}
