package com.test.socketCode_10.bsuploads;

/*
* 返回浏览器时，需要先回传头部信息为：
* sops.write("HTTP/1.1 200 OK\r\n".getBytes());
        sops.write("Content-type:text/html\r\n".getBytes());
        sops.write("\r\n".getBytes());
* */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

    public static void main(String[] args) throws IOException {
        String filePath="fun_test\\src\\com\\test\\socketCode_10\\fileUploads\\client.txt.bak";

        ServerSocket server = new ServerSocket(8080);
        Socket conn = server.accept();

        InputStream sips = conn.getInputStream();

        FileOutputStream ops = new FileOutputStream(filePath);
        int len=0;
        byte[] arr = new byte[1024];
//        while((len=sips.read(arr))!=-1){
//            System.out.println(new String(arr,0,len));
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(sips));
        String line = br.readLine();
        String ar=line.split(" ")[1];
        ar = ar.substring(1);
        System.out.println(ar);

        FileInputStream ips = new FileInputStream("fun_test\\src\\com\\test\\socketCode_10\\bsuploads\\client.html");

        OutputStream sops = conn.getOutputStream();
        sops.write("HTTP/1.1 200 OK\r\n".getBytes());
        sops.write("Content-type:text/html\r\n".getBytes());
        sops.write("\r\n".getBytes());
        while((len=ips.read(arr))!=-1){
            sops.write(arr,0,len);
        }
        conn.shutdownOutput();
        ops.close();
        conn.close();
        server.close();
    }

}
