package com.train.io.bio;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @Time: 20-4-7下午8:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Client {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("localhost", 8080);
                while (true){
                    socket.getOutputStream().write((new Date() + ": hello world " + Thread.currentThread().getName()).getBytes());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
