package com.test.socketCode_10.fileUploadsAdvance;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1235);
        OutputStream sops = socket.getOutputStream();
        String filePath = "fun_test\\src\\com\\test\\socketCode_10\\fileUploads\\test.txt";

        FileInputStream ips = new FileInputStream(filePath);
        byte[] arr = new byte[1024];
        int len = 0;
        while ((len = ips.read(arr)) != -1) {
            sops.write(arr, 0, len);
        }
        socket.shutdownOutput();

        InputStream sips = socket.getInputStream();

        while ((len = sips.read(arr)) != -1) {
            System.out.println(new String(arr, 0, len));
        }
        ips.close();
        socket.close();
    }
}

