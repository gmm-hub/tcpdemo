package com.gmm.myitem.socketitem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {

        //1.绑定端口
        ServerSocket serverSocket = new ServerSocket(10001);
        //2.监听端口
        Socket socket = serverSocket.accept();
        //3.获取输入流对象
        InputStream inputStream = socket.getInputStream();
        byte[] bs = new byte[1024];
        int read = inputStream.read(bs);
        String st = new String(bs,0,read);
        System.out.println("数据是："+st);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("数据已收到".getBytes());
        //4.释放资源
        socket.close();
        serverSocket.close();

    }
}
