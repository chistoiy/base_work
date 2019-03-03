package com.test.fileOperate_09;

/*
* Properties 类是一个持久的属性集合，双列，key与value默认都是字符串，且与IO流相结合
*       使用store，持久化存储本地
*       使用load载入本地的文件到集合中使用
*   Object setProperties(String key ,String value)调用Hash table的方法put
*   String getProperties(String key )通过key得到value值，相当于map中的get
*    set<String> String stringPropertyNames(),返回此集合中的key，放于set集合中
*
* store方法应用
*        void store(OutputStream out, String comments)  comments参数是表示注释用的，
*         以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。
*       void store(Writer writer, String comments)
*         以适合使用 load(Reader) 方法的格式，将此 Properties 表中的属性列表（键和元素对）写入输出字符。

*
* load方法应用
*        void load(InputStream inStream)
          从输入流中读取属性列表（键和元素对）。
        void load(Reader reader)
          按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。

*
* */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest04 {
    public static void main(String[] args) throws IOException {
//基本用法
//        show();
        show2();
    }

    public static void show() {
        Properties prop = new Properties();

        prop.setProperty("小黑", "189");
        prop.setProperty("小白", "190");
        prop.setProperty("小紫", "199");
        prop.setProperty("小红", "180");

        String st = prop.getProperty("小白");
        System.out.println(st);

        Set<String> set = prop.stringPropertyNames();
        for (String s : set) {
            System.out.println(prop.get(s));
        }
    }

    public static void show2() throws IOException {
        Properties p = new Properties();

        p.setProperty("小二黑", "结婚");

        FileWriter w = new FileWriter("fun_test\\src\\com\\test\\fileOperate_09\\propertiesfile.txt");
        p.store(w, "|");//后一参数是注释
        w.close();
        Properties p2 = new Properties();
        FileReader r = new FileReader("fun_test\\src\\com\\test\\fileOperate_09\\propertiesfile.txt");
        p2.load(r);

        System.out.println(p2.getProperty("小二黑"));
    }
}
