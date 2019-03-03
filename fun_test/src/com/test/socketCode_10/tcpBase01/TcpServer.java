package com.test.socketCode_10.tcpBase01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(1234);
        Socket conn =socket.accept();
       InputStream is =  conn.getInputStream();
        System.out.println((char) is.read());
        OutputStream os = conn.getOutputStream();
        os.write('b');

        conn.close();
        socket.close();
    }
}
