package com.test.supply_12.test;

/*
 * Junit测试
 *   测试，黑盒 只需要input，然后看output是否与预期一致
 *         白盒 需要看处理过程
 *   步骤：
 *       定义测试类（测试用例）
 *           测试类名：被测试的类名Test
 *           包名：xxx.xxx.xx.test
 *       定义测试方法：可独立运行
 *           方法名：test测试的方法名
 *           返回值：void
 *           参数列表：空参
 *       给方法加@Test
 *           需要导入Junit的依赖
 *           方法内，实例测试类对象，然后执行其中一个方法，
 *           执行的方法返回的结果可以不打印，而是根据我们输入的参数，由我们自己设置一个值
 *           然后使用断言来判断测试方法返回值是否与设置的值一致即可
 *          如果断言不一致，则报异常查看输出即可
 *
 *
 *      重复操作，
 *          init()方法,初始化方法，所有测试方法执行之前都会先执行该方法，使用语法糖@Before修饰
 *          close(),在所有测试方法执行完毕后，用于释放资源，即使出现异常，close依旧会被执行
 * */


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.test.supply_12.JunitTestPack.Caluculator;
public class CaluculatorTest {
    @Before
    public void init(){
        System.out.println("init...");
    }
@After
    public void close(){
        System.out.println("close");
    }

    /*
    * 测试add方法
    * */
    @Test
    public void testAdd(){
        System.out.println("执行add测试");
        Caluculator calcultor=  new Caluculator();
        int result = calcultor.add(1,2);
//        System.out.println(result);
        Assert.assertEquals(result,3);

    }
    @Test
    public void testSub(){
        System.out.println("执行add测试");
        Caluculator calcultor=  new Caluculator();
        int result = calcultor.sub(1,2);
//        System.out.println(result);
        Assert.assertEquals(result,1);

    }
}
