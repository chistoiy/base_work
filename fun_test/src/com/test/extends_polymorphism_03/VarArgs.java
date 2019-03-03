package com.test.extends_polymorphism_03;
/*
*当方法的参数列表数据类型已经确定，但参数个数不确定时可以使用可变参数
* java1.5之后出现的可变参数
* 格式：定义方法时使用
*       修饰符 返回值类型 方法名(数据类型 ...变量名){}
* 原理：
*   底层时数组，根据传递参数个数不同，会创建不同长度数组来存储这些参数
*           个数0+；
* 注意：
*   一个方法参数列表只能有一个可变参数
*   当方法有多个参数时，可变参数必须在末尾
* */
public class VarArgs {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(add(a));
    }

    static int add(int ... args){//args实际上时按照传递参数来实时创建数组
        int sum = 0;
        for (int arg : args) {
            sum+=arg;
        }
        return sum;
    }
}
