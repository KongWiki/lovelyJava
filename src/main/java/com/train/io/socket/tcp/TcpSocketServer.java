package com.train.io.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @Time: 2020/5/15下午9:12
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TcpSocketServer implements Runnable{
    private Socket client = null;

    public TcpSocketServer(Socket client){
        this.client = client;
    }
    @Override
    public void run() {
        try {
            //获取Socket的输出流，用来向客户端发送数据
            PrintStream out = new PrintStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从客户端发送过来的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag =true;
            while (flag){
                String echo = buf.readLine();
                if(echo == null || "".equals(echo)){
                    flag = false;
                }else{
                    if("bye".equals(echo)){
                        flag = false;
                    }else{
                        //将接收到的字符串前面加上echo，发送到对应的客户端
                        out.println("server echo:" + echo);
                    }
                }
            }
            out.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
