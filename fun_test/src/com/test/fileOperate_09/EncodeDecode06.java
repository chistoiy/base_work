package com.test.fileOperate_09;

/*
*   FileReader读取过程为：
*       底层使用FileInputStram来读取后，FileReader查询IDE默认码表后解码显示
*
*   InputStreamReader
*       Reader的子类不支持读取文件时可以指定编码
*       构造方法
*写的操作：
*   FileWriter过程：
*       先查询IDE默认编码后使用FileOutputStream写操作
*   OutputStreamWriter
*       构造方法：
*          OutputStreamWriter(outputStream ops，String charset)//GBK，UTF-8,默认是UTF-8
*
*
* */

import java.io.*;
import java.nio.charset.Charset;

public class EncodeDecode06 {
    public static void main(String[] args) throws IOException {
        writer();  //写一个gbk文件
        reader();//读上面的gbk文件
        convert();//转换上面的gbk到utf-8
    }



    private static void reader() throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("output.txt"),"GBK");
        int len = 0;
        while((len=isr.read())!=-1){
            System.out.println(len);
            System.out.println((char)len);
        }

    }

    private static void writer() throws IOException{

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("output.txt"),"GBK");
        osw.write("你好");
        osw.close();
    }
    private static void convert() throws IOException {

        InputStreamReader isp=new InputStreamReader(new FileInputStream("output.txt"),"GBK");
        OutputStreamWriter ops =new OutputStreamWriter(new FileOutputStream("endconvert.txt"),"UTF-8");
        int len=0;
        while((len=isp.read())!=-1){
            ops.write(len);
        }
        ops.close();
        isp.close();


    }





}
