package com.test.basework01;

/*
 * Object是所有类的超类，所有对象都是会实现object的tostring方法
 *   toString()
 *   equals() 用于判断两对象的地址是否一样,此处重写为判断对象的属性一致即认为是一样的
 *              此方法与Objects.equals()区别在于，Objects允许空指针使用比较，即null.equals()
 *
 *
 * */

class PersonTest {
    private String name;
    private int age;

    public PersonTest() {
    }

    public PersonTest(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(getClass());//反射

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

    @Override
    public String toString() {
//        return super.toString();
//        return "asb";
        return "Person:" + name + ",age:" + age;
    }

    @Override
    public boolean equals(Object obj) {
//       return  super.equals(obj);
        if (obj == null) {
            return false;
        }
        if (obj instanceof PersonTest) {
            PersonTest p = (PersonTest) obj;
            return this.name.equals(p.name) && this.age == p.age;
        }
        if(obj == this){
            return true;
        }

        return false;
    }
}

public class ObjectTest {
    public static void main(String[] args) {
        PersonTest person = new PersonTest("张三", 17);
        System.out.println(person);

        //equals()

        PersonTest p1 = new PersonTest("q", 1);
        PersonTest p2 = new PersonTest("q", 1);
        System.out.println(p1.equals(p2));


    }
}
