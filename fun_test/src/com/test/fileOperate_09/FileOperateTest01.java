package com.test.fileOperate_09;
/*
* 文件和目录路径名的抽象表示形式。
*用户界面和操作系统使用与系统相关的路径名字符串 来命名文件和目录。此类呈现分层路径名的一个抽象的、与系统无关的视图。
* 抽象路径名 有两个组件：
*    1.一个可选的与系统有关的前缀 字符串，比如盘符，"/" 表示 UNIX 中的根目录，
*                                   "\\\\" 表示 Microsoft Windows UNC 路径名。
*   2.零个或更多字符串名称 的序列。
*
*       路径不区分大小写
*       文件名称分割符
*
*   静态方法;
*       pathSeparator
*       separator 路径分隔符
*
*
* */

import java.io.File;
import java.io.IOException;

public class FileOperateTest01 {
    public static void main(String[] args) throws IOException {
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        File f1= new File("D:\\workplace\\for_java\\base_work\\fun_test\\src\\com\\test\\fileOperate_09\\FileOperateTest01.java");
        System.out.println( f1.getName());
        System.out.println(f1.isFile());

        File f2= new File("D:\\workplace\\for_java\\base_work\\fun_test\\src\\com\\test","fileOperate_09\\FileOperateTest01.java");
        System.out.println(f2.toString());
        System.out.println(f2.isFile());
        System.out.println(f2.getAbsolutePath());// 返回此抽象路径名的绝对路径名字符串
        System.out.println(f2.length());//返回由此抽象路径名表示的文件的长度,单位字节
        System.out.println(f2.getPath());//将此抽象路径名转换为一个路径名字符串。
        System.out.println(f2.getName());//返回由此抽象路径名表示的文件或目录的名称
        System.out.println(f2.isDirectory());
        System.out.println(f2.exists());//  测试此抽象路径名表示的文件或目录是否存在。

        //创建与删除
        File f3 = new File("a.txt");

            f3.createNewFile();//
        File f4 = new File("apitest_02\\a");
        System.out.println(f4.mkdirs());
        System.out.println(f4.getAbsolutePath());
        System.out.println(f4.isDirectory());
    ;//文件夹不存在则创建，否则不创建，返回false

        if(f3.exists()){
        f3.delete();//删除
        }


        //遍历 list不能遍历文件，地址不存在也会报错
        // listFile 返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录
        File f6 = new File("D:\\workplace\\for_java\\base_work\\fun_test\\src\\com\\test");
        for (String s : f6.list()) {
            System.out.println(s);
        }
        File f7 = new File("D:\\workplace\\for_java\\base_work\\fun_test\\src\\com\\test");
        for (File file : f7.listFiles()) {
            System.out.println(file+"asssssewwwwwwww");

            }
        }



}
