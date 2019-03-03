package com.test.extends_polymorphism_03.test1;

public class ExtendsTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.method();
        Assistant assistant = new Assistant();
        assistant.method();
        teacher.test();
    }

}
