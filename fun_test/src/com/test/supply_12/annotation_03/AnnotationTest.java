package com.test.supply_12.annotation_03;

import java.lang.annotation.*;

/*
 * 注解：
 *   用于说明程序，主要用于给计算机使用
 *   元数据，jdk1.5
 *   作用分类
 *       编写文档，通过代码里标识的元数据生成文档《生成doc文档》
 *       通过元数据对代码进行分析《使用反射》
 *       编译检查，让编译器能够实现基本的编译检查《override》
 * @author mylife
 * @version 1.0
 * @since 1.5
 *       @override
 *       @Deprecated  该注释标注的内容已经过时
 *       @SuprressWarnings 压制警告的@SuprressWarnings(all),位置在类名之上
 * 自定义注解
 *       格式：
 *           public @interface 注解名称{
 *
 *               }
 *       使用时在需要注解的方法上使用，与@override类似
 *
 *       注解本质就是接口的继承接口，ectends java.lang.annotation.Annotation
 *
 *          抽象方法：
 *              属性的返回值类型：基本数据类型，String，枚举，注解
 *                  如果定义时，使用default，则设置默认值
 *          使用时，将抽象方法名放置于语法糖的参数位，并为之赋予相应类型的值，多值时使用逗号间隔
 *          如果只有一个属性需要赋值，且属性名为value，则可以直接在参数为赋值即可
 *          如果属性需要数组，值需要使用{}包裹，如果数组只有一个元素，则可以不使用{}
 *
 *  元注解：用于描述注解的注解
 *      @Target注解能够作用的位置
 *          //ElementType.TYPE/METHOD/FIELD,类/方法/参数  value赋值可以以一个数组来赋值多个
 *      @Retention注解被保留的阶段
 *              参数位：
 *              RetentionPolicy.RUNTIME 当前被描述的注解，会被保留到class字节码文件中,并被JVM读取到
                RetentionPolicy.SOURCE当前被描述的注解，不会被保留到class字节码文件中,
                RetentionPolicy.CLASS当前被描述的注解，会被保留到class字节码文件中,不会被JVM读取
 *      @Documented 注解是否被抽取到api文档中
 *
 *      @Inherited 注解是否被子类继承
 *
 *   反射中获取的method判断是否有某一个注解，使用：
 *      method.isAnnotationPresent(Chech.class),即传入该注解的类型
 * */

public class AnnotationTest {

    /*
     * @param a 整数
     * @param b 整数
     * @return 累加值
     * */
    @annotationInterface(show=12)
    public int add1(int a,int b){
        return a+b;
    }
    @Deprecated
    public int add2(int a,int b){
        return a+b;
    }

    public void show(){
        System.out.println("allalala");
    }


}

//自定义注解
 @interface annotationInterface {
         int show() default 123;//当不赋值时默认时123

}

/*annotationInterface 注解接口实际上是这样的
interface annotationInterface extends java.lang.annotation.Annotation{

}*/


//元注解
@Target(value = ElementType.TYPE)//表示这个注解只能用于类上
        //ElementType.TYPE/METHOD/FIELD,类/方法/参数  value赋值可以以一个数组来赋值多个
@Retention(RetentionPolicy.CLASS)//代表
    @Documented
@interface Mynote{

}