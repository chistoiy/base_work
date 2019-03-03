package com.test.supply_12.relect_02;

/*
* 设置一个框架，用于返回一个类的参数
*   实现：
*       配置文件
*       反射
*   步骤：
*       将需要创建对象那个的全类名和需要执行方法的定义在配置文件
*           className
*           methodName
*       在程序中加载读取配置文件
*       使用反射技术加载进内存
*       创建对象
*       执行方法
* */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest02 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties properties = new Properties();
        ClassLoader classLoader=ReflectTest02.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("\\com\\test\\supply_12\\relect_02\\pro.properties");//读取src目录下的文件
//        int len=0;
//        byte[] arr=new byte[1024];
//        while((len=is.read(arr))!=-1){
//            System.out.println(new String(arr,0,len));
//        }
        properties.load(is);

        //获取配置文件定义数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //加载类进内存
        Class cls= Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}





