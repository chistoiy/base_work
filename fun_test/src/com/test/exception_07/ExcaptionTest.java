package com.test.exception_07;

/*
*异常处理：
*   关键字try、catch、finally、throw、throws
*      throw关键字     抛出指定方法中的异常
*           格式：
*               throw new xxxException("异常产生原因")
*                   throw必须写在方法内部
*                   new的对象必须是Exceptoion或Exception的子类对象
*                   throw关键字抛出的异常对象，就必须处理这个异常对象
*                           如果new的是RuntimeException或RuntimeException的子类对象可以不处理，默认交由jvm处理（中断打印）
*                           创建的是编译异常，就必须处理，要么throws，要么try。。。catch
*      Object的非空判断
*      throws关键字
*           1.交由其他来处理
*               作用：方法内部抛出异常对象时，那就必须处理这个异常
*                   可以使用关键字处理异常对象，会把异常对象抛给方法的调用者处理（自己不处理时，则交给jvm处理）
*                格式：
*                   修饰符 返回值类型 方法名（参数列表） throws AAAException ，BBBException。。。{
*                       throw new AAAException('产生原因')；
*                       throw new BBBException('产生原因')；
*                   }
*                   throws关键字必须卸载方法声明处
*                   内部抛出多个异常对象，那么throws必须也声明多个异常，父类关系则声明父类异常即可
*                   调用了一个声明抛出异常的方法，就必须处理声明的异常
*                       要么throws声明抛出，交给方法调用者处理，最终交给jvm
*                       要么try。。。catch自己处理异常
*       try...catch
*               Throwable类定义三个异常处理方法,此类也就是catch捕获后，e的所具有方法
*                   String getMessage()返回此throwable的简短描述
*                   String toString()返回此的详细消息字符串
*                   void printStackTrace() JVM打印异常对象，默认调用此方法
*           catch捕获多个异常对象时，子类必须写在父类之前，否则报错
*                 一次捕获一次处理，则使用Exception来处理
*
* 子父类异常关系
*       父类声明异常，子类只能声明父类异常或异常的子类
*       父类声明异常，子类可以不声明异常
*       父类方法没有抛出异常时，子类重写父类方法时也不可以抛出异常，
*           此时若子类产生该异常，只能捕获处理，不能声明抛出
*
*  自定义异常
*
* */

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ExcaptionTest {
    static String [] usernames={"AA","BB","CC"};
    public static void main(String[] args) {
        //throw测试
        //   int[] arr = null;
        //            int e =getElement(arr,0);
        //            System.out.println(e);
        //Object非空判断
        //        SendObject(null);

        //throws测试
        //throwsTest("ddd"); 需要给main方法添加 throws IOExcption
        //try..catch
//        try{
//            tryCatch("asad");
//            }catch (IOException e){
//            System.out.println("异常被捕获了");
//            //System.out.println(e.toString());
//        }
//        catch (NullPointerException e){
//            System.out.println("异常被捕获了");
//            //System.out.println(e.toString());
//        }finally {
//            System.out.println("无论是否出现异常，这一段代码都会执行");
//            System.out.println("资源释放或者资源回收使用居多");
//        }
//        System.out.println("继续执行");

        //自定义异常
        Scanner sc =new Scanner(System.in);
        String username = sc.next();
        try{
            checkUsername(username);
            }catch (ResterException e){
            System.out.println(e.toString());
            }
}


    static int getElement(int[] arr,int index){//throw判断
        if (arr==null){
            throw new NullPointerException("异常：传递数值为空");
        }
        if(index>=arr.length || index<0){
            throw new ArrayIndexOutOfBoundsException("数组索引越界");
        }
        int ele= arr[index];
        return ele;

    }

    static void SendObject(Object obj){ //object非空判断
        Objects.requireNonNull(obj,"传递对象的值是null");
    }

    static void throwsTest(String filename) throws IOException {
        if(!filename.equals("c://a.txt")){
            throw new IOException("文件地址不存在");
        }
    System.out.println("文件地址正确");

    }

    static void tryCatch(String filename) throws IOException{//try...catch
        if(!filename.equals("c://a.txt")){
            throw new IOException("文件地址不存在");
        }
        System.out.println("文件地址正确");

    }

    static void checkUsername(String username) throws ResterException{
        for (String name : usernames) {
            if(name.equals(username)){
                throw new ResterException("用户名已注册");
            }
        }
    }



}


//自定义异常
/*
* public class XXXException extends Exception | EuntimeException{
*           添加空参数的构造方法
*           提娜佳带异常信息的构造方法
*           }
* */
class ResterException extends Exception{

    public ResterException(){
        super();
    }

    public ResterException(String message) {
        super(message);
    }
}