package com.test.socketCode_10.fileUploads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        String filePath="fun_test\\src\\com\\test\\socketCode_10\\fileUploads\\test.txt.bak";

        ServerSocket server = new ServerSocket(1235);
        Socket conn = server.accept();

        InputStream sips = conn.getInputStream();

        FileOutputStream ops = new FileOutputStream(filePath);
        int len=0;
        byte[] arr = new byte[1024];
        while((len=sips.read(arr))!=-1){
            ops.write(arr,0,len);
        }
        OutputStream sops = conn.getOutputStream();
        System.out.println("已保存".getBytes());
        sops.write("已保存".getBytes());
        conn.shutdownOutput();
        ops.close();
        conn.close();
        server.close();
    }

}
