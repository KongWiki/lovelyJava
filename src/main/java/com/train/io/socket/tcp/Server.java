package com.train.io.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Time: 2020/5/15下午9:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //服务端在20006端口监听客户端请求的TCP连接
        ServerSocket server = new ServerSocket(20006);
        Socket client = null;
        boolean f = true;
        while(f){
            //等待客户端的连接，如果没有获取连接
            client = server.accept();
            System.out.println("与客户端连接成功！");
            //为每个客户端连接开启一个线程
            new Thread(new TcpSocketServer(client)).start();
        }
        server.close();
    }
}
