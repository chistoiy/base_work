package com.test.extends_polymorphism_03.polymorphismTest;

public class Zi extends Fu {
    public int age=14;
    @Override
    public void method() {
        System.out.println("子类的method方法");
    }

    public void methodZi() {
        System.out.println("子类独有的method方法");
    }
}