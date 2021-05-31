package com.gmm.myitem.socketdemo1;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class SocketThread implements Runnable {

    private Socket s;
    public SocketThread(Socket socket) {
        this.s = socket;
    }

    public void run() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("age.text"));
            UUID uuid = UUID.randomUUID();
            String filename = uuid.toString()+".txt";
            File file = new File(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            String line;
            while ((line = reader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            writer.write("文件上传成功！");
            writer.newLine();
            writer.flush();

        }catch ( IOException e){
            e.printStackTrace();
        }


    }
}
