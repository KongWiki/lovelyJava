package com.train.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Time: 20-4-7下午8:33
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        new Thread(()->{
            try {
                Socket accept = serverSocket.accept();
                new Thread(()->{
                    int len;
                    byte[] data = new byte[1024];
                    try {
                        InputStream inputStream = accept.getInputStream();
                        while ((len=inputStream.read(data)) != -1){
                            System.out.println(new String(data, 0, len)+" " + Thread.currentThread().getName());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
   }
}
