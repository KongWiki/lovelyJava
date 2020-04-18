package com.train.concurrent.webServer.poorDesign;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Time: 20-4-18下午10:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true){
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {

    }
}
