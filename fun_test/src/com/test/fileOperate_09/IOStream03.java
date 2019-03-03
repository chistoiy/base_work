package com.test.fileOperate_09;

import java.io.*;

/*
 * IO流
 *   字节流 InputStream OutputStream
 *   字符流 Reader Writer
 *OutputStream 子类共性成员方法
 *   public void close() 关闭输出流并释放与此流相关任何系统资源
 *   public void flush() 刷新此流并强制任何缓冲的输出字节被写出
 *   public void write(byte[] b)写出b.length长字节的字节数组
 *   public void write(byte[] b,int off,int len) 写出len长字节,从off开始偏移量位置
 *   public abstract void write(int b )指定字节输出流
 *
 *   继承类：
 *       FileOutputStream ，文件字节输出流
 *           构造方法(String name，boolean append),创建一个具有指定名称的文件中写入数据的输出文件流,
 *               默认append为true，追加写入，false是覆盖写入
 *               文件不存在时，会新建一个空白文件；
 *               换行则写入时，写入 \r\n
 *           (File file),创建一个向指定file对象表示的文件中写入数据的文件输出流
 *
 *
 *           写数据时，将10进制整数转换为二进制形式，1~127会表示成ascll，其他的使用当前系统默认码表来显示
 *           如果在存储时，第一个数字时负数，那么在转换时，就会连带后一个字节一起转译为中文
 *
 *InputStream
 *   public void close() 关闭输出流并释放与此流相关任何系统资源
 *   public void read()读下一字节
 *   public int read(byte[] b) 读一定量长度字节，存储进数组b中
 *               返回的int为每次读取的有效字节个数
 *
 *Reader 字符输入流 抽象类
 *       共性成员方法
 *           public void close() 关闭输出流并释放与此流相关任何系统资源
 *           public void read()读单个字符
 *           public int read(char[] cbuf) 读一定量长度字符，存储进数组
 *               返回的int为每次读取的有效字节个数
 *       子类：
 *           FileReader
 *
 *  flush与close区别在于，flush刷新缓冲区，内容写入，流对象还可以继续使用
 *       close刷新缓冲器，清理系统资源，流对象不可再使用
 *
 *
 *   try...catch ...finally，处理流对象设置作用域麻烦的操作
 *   jdk1.7+ 在try后添加()，其中定义流对象的代码部分，此时这个流对象的作用域就在try中有效，代码执行后自动释放流对象，不需要finally再写了
 *   jdk1.9+ 再try的前面定义流对象，再try后面的()直接引入这个流对象变量名，再try代码块执行完后也自动释放流对象，不需要写finally
 *
 * 缓冲流
 *
 * */
public class IOStream03 {
    public static void main(String[] args) throws IOException {


//        outputstreaminputstream();
//        copyImage();
//        readerwriter();


    }

    static void outputstreaminputstream() throws IOException {
        //默认是追加写入
        FileOutputStream r = new FileOutputStream("a.txt");
        r.write(96);
        //字符串写入
        r.write(new byte[]{'1', '2', '3', '4'});
        String s = "你好";
        r.write(s.getBytes());

        r.close();
//覆盖
        FileOutputStream r2 = new FileOutputStream("a.txt", false);
        String ss = "你好";
        r2.write(s.getBytes());
        r2.close();

        FileInputStream i = new FileInputStream("a.txt");
        //int b = (byte)i.read();
        System.out.println(i.read());
        System.out.println(i.read());
        System.out.println(i.read());
        System.out.println(i.read());
        System.out.println(i.read());
        System.out.println(i.read());
        System.out.println(i.read());
        System.out.println(i.read());
        i.close();

        FileInputStream i2 = new FileInputStream("a.txt");
        byte[] arr = new byte[3];
        int ll = i2.read(arr);
        System.out.println(ll);
        for (byte b : arr) {
            System.out.print(b);
        }
        System.out.println();
        System.out.println(new String(arr));
        r2.close();
    }

    static void copyImage() throws IOException {
        //
        FileInputStream ii = new FileInputStream("fun_test//01_input.jpg");
        FileOutputStream oo = new FileOutputStream("fun_test//01_input_bak.jpg");

        byte[] ar = new byte[1024];
        int len = 0;
        while ((len = ii.read(ar)) != -1) {
            //ii.read(ar);
            oo.write(ar, 0, len);

        }
        oo.close();
        ii.close();
    }

    static void readerwriter() throws IOException {

        FileWriter w = new FileWriter("fileread.txt");
        w.write("你好啊");
        char[] arr = "你是我的小玫瑰啊".toCharArray();
        w.write(arr);
        w.close();
/*
        FileReader r = new FileReader("fileread.txt");
        int len =0 ;
        while((len = r.read())!=-1){
        System.out.println((char)len);}
        r.close();
*/
        FileReader r2 = new FileReader("fileread.txt");
        char[] ar = new char[1024];
        int len2 = 0;
        while ((len2 = r2.read(ar)) != -1) {
            System.out.println(new String(ar, 0, len2));
        }
        r2.close();


    }

    static void tryCatch(){

        try (FileWriter a = new FileWriter("a.txt");){

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
