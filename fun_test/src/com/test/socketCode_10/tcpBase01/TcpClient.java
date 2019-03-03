package com.test.socketCode_10.tcpBase01;

/*
* Socket实现套接字，包含了ip和端口号的网络单位
*   构造方法：
*       Socket(String host,int port)
*    成员方法：
*       OutputStream getOutputStream() 返回此套接字的输出流
*       InputStream getInputStream()返回此套接字的输入流
*       void close()关闭套接字
*   步骤：
*       创建socket对象，绑定ip，端口
*       使用getOutputStream，获取字节输出流对象
*           使用其write，发送数据
*       使用getInputStream()获取输入流对象
*           使用其read，读取数据,当read没有数据时，将进入阻塞状态与普通IO读取文件结束不一样
*          这样的话，在正常传输完毕后，使用套接字对象的shutdowmOutput()方法，通知对方传输完毕即可结束传输流
*
*       close关闭流
* */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",1234);
        OutputStream os = socket.getOutputStream();
        os.write('a');
        InputStream is =socket.getInputStream();
        System.out.println((char)is.read());
        socket.close();
    }

}
