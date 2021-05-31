package com.gmm.myitem.socketdemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        //绑定端口
        ServerSocket serverSocket = new ServerSocket(10001);
        //监听客户端对象
        Socket accept = serverSocket.accept();
        //获取输入流对象
        BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String line;
        //打印输入流
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
        //释放资源
        serverSocket.close();
    }
}
