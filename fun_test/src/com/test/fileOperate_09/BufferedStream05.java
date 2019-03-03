package com.test.fileOperate_09;
/*
* BufferedStream
*       增强四种基本IO流
*           给基本字节/字符输入流增加一个缓冲区（数组）提高基本的读取效率
*       使用方式主要就是在四种基本IO流之上需要将四种IO流对象当作参数传递给相应的BufferedStream的构造方法，其他的操作方式均一样
*
*       做测试可知，在文件较小时（视电脑性能而定，文件小于400M时，buffered流性能不会体现出来）
*
*   字符流特有方法
*       void newLine()写入一个行分隔符
*       String readLine 返回该行的字符串，不包含行终止符号，到末尾时返回null
* */


import java.io.*;

public class BufferedStream05 {
    public static void main(String[] args) throws IOException {
        //method3();
        File f = new File("fileWrite.txt");
        System.out.println(f.length()/1024+"k");
        long a = System.currentTimeMillis();
        method();
        System.out.println(System.currentTimeMillis()-a+"a");
       long b =System.currentTimeMillis();
       method2();
       System.out.println(System.currentTimeMillis()-b+"b");



    }

    private static void method3() throws IOException {
        FileWriter w = new FileWriter("fileWrite.txt");

        char [] ar = new  char[1024];
        for (int i = 0; i < 10000; i++) {
             String st = "啦啦啦啦歇一会再说"+"\r\n";
            char [] arr = st.toCharArray();

            w.write(arr);

        }
        w.close();



    }

    static void method() throws IOException {
//        FileReader r = new FileReader("fileWrite.txt") ;
        FileReader r = new FileReader("aaaa.mp4") ;
        //FileReader r = new FileReader("fileWrite.txt") ;
        char [] ar = new char[1024];
        BufferedReader br = new BufferedReader(r);
//        BufferedWriter bw = new BufferedWriter(new FileWriter("bufferfileWrite.txt") );
        BufferedWriter bw = new BufferedWriter(new FileWriter("bufferfileaaaa.mp4") );
        int len = 0;
        while((len=br.read(ar))!=-1){
bw.write(ar,0,len);
            //System.out.println(new String(ar,0,len));
        }
        bw.close();

    }

    static void method2() throws IOException {
//        FileReader br = new FileReader("fileWrite.txt") ;
        FileReader br = new FileReader("aaaa.mp4") ;
//        FileWriter bw = new FileWriter("nobuferfileWrite.txt") ;
        FileWriter bw = new FileWriter("nobuferfileaaaa.mp4") ;
        char [] ar = new char[1024];
        //BufferedReader br = new BufferedReader(r);
        int len = 0;
        while((len=br.read(ar))!=-1){
            bw.write(ar,0,len);
            //System.out.println(new String(ar,0,len));
        }
bw.close();
    }


}
