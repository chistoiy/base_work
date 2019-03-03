package com.test.inerclass_outerclass_04.t01;

public class BodyClass {//外部类

    public int num = 10;
    public int age =20;

    public class Innerclass{//内部类
        public int inum = 30;
        public int age = 40;
        public void innerMethod(){//内部类的成员方法
            System.out.println("成员内部类的方法");
            System.out.println("成员内部类打印外部类的成员变量："+num);
            System.out.println("成员内部类打印内部类的重名成员变量："+this.age);
            System.out.println("成员内部类打印外部类的重名成员变量："+BodyClass.this.age);

        }
    }

    public void innermethod(){
        Innerclass inner = new Innerclass();
        inner.innerMethod();
        System.out.println("打印成员内部类的变量："+inner.inum);
        System.out.println("成员内部类打印内部类的成员变量："+inner.age);
        System.out.println("成员内部类打印外部类的重名成员变量："+BodyClass.this.age);
    }



    public void outerMethod(){
        System.out.println("局部内部类开始");
          class LocalInnerClass{//局部内部类
                    public void localInnerMethod(){
                        System.out.println("局部内部类的方法被执行");
                    }
        }
        LocalInnerClass i = new LocalInnerClass();
          i.localInnerMethod();
    }


}
