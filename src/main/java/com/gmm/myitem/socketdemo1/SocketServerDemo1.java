package com.gmm.myitem.socketdemo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);

        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("s.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("文件上传成功");
        writer.flush();
        writer.close();
        bufferedWriter.close();
        serverSocket.close();
    }

}
