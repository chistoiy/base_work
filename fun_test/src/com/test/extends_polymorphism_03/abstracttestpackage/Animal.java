package com.test.extends_polymorphism_03.abstracttestpackage;
/*
* 抽象类的结构，类定义时使用abstract修饰，然后设置抽象方法，同样使用abstract修饰，但是只留出参数位置，不用留方法体（不用写{}）
* 子类继承时，必须覆盖重写抽象类的抽象方法体，idea快捷键，在子类继承处，使用alt+enter，提示有implement，选择即可
*       如果子类也是用了abstract修饰，并且没有完全重写所有的抽象方法，则该子类也是一个抽象类，同样也是一个抽象类，被用于继承使用
* 抽象类不一定必须包含抽象方法，同时抽象类可以包含非抽象方法，子类调用时只能使用super来覆盖重写调用
* */
public abstract class Animal {
    public abstract void eat();


}
