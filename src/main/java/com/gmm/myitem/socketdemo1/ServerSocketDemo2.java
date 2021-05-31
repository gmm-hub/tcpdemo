package com.gmm.myitem.socketdemo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);

        while (true){
            Socket socket = serverSocket.accept();

            new Thread(new SocketThread(socket)).start();
        }

    }
}
