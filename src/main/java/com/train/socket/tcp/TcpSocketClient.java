package com.train.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @Time: 2020/5/15下午8:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TcpSocketClient {
    public static void main(String[] args) throws IOException {
        // 请求链接 本地 端口： 20006
        Socket client = new Socket("localhost", 20006);
        client.setSoTimeout(10000);
        // 获取输入内容
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // Socket输出流 输出到服务器
        PrintStream out = new PrintStream(client.getOutputStream());
        // Socket输入流 接受服务端数据
        BufferedReader buf = new BufferedReader((new InputStreamReader(client.getInputStream())));
        boolean flag = true;
        while (flag){
            System.out.println("输入信息");
            String str = input.readLine();
            out.println(str);
            if("bye".equalsIgnoreCase(str)){
                flag = false;
            }else{
                String echo = buf.readLine();
                System.out.println(echo);
            }
        }
        input.close();
        if(client != null){
            client.close();
        }
    }

}
