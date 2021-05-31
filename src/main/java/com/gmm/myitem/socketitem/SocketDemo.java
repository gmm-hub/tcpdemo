package com.gmm.myitem.socketitem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        //1.绑定端口
        Socket socket = new Socket("192.168.20.152", 10001);
        //2.获取输出流对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好tcp".getBytes());
        //获取服务端的反馈

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String data = new String(bytes,0,read);

        System.out.println("服务器的反馈数据是："+data);
        //3.释放资源
        socket.close();

    }
}
