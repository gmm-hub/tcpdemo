package com.gmm.myitem.socketdemo1;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.20.152", 10001);
        //发送数据到服务器
        BufferedReader reader = new BufferedReader(new FileReader("pom.xml"));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line = reader.readLine()) != null){
            writer.write(line);
            writer.newLine();
            writer.flush();
        }
        //结束标志
//        writer.write("886");
//        writer.newLine();
//        writer.flush();
        socket.shutdownOutput();
        //获取服务器的反馈
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader1.readLine());
        writer.close();
        socket.close();

    }
}
