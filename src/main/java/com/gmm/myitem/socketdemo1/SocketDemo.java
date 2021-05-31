package com.gmm.myitem.socketdemo1;

import java.io.*;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.20.152", 10001);

        //数据源于键盘输入，直到输入886结束
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line=reader.readLine())!=null){
            if ("886".equals(line)){
                break;
            }

            writer.write(line);
            writer.newLine();
            writer.flush();

        }
        socket.close();

    }
}
