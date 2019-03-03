package com.test.extends_polymorphism_03.interfaceTest;
/*
* 接口的实现类
*一个类直接父类时唯一且只有一个的，但是可以实现多个接口类
*   多接口实现如果有重名的抽象方法，只需覆盖重写其中一个即可
*   多接口有重复默认方法（报冲突），则需要需要覆盖重写
* 一个类如果父类与接口的方法冲突，优先使用父类的（接口类的static 返回值 方法名（）{}）
*
*
* */
public class MyInterfaceAbstractImpl implements MyInterfaceAbstract {

    @Override
    public void methodAbs() {
        System.out.println("lalalla");
    }
}
