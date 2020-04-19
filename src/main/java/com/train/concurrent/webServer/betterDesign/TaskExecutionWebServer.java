package com.train.concurrent.webServer.betterDesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;

/**
 * @Time: 20-4-18下午11:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TaskExecutionWebServer {
    private static Logger logger = LoggerFactory.getLogger(TaskExecutionWebServer.class);

    private static final Executor exec = ExecutorFactory.newExecutor();

    public static void main(String[] args) throws IOException {
        logger.info("The executor you are using is {}", exec);
        ServerSocket socket = new ServerSocket(80);
        while (true){
            final Socket connect = socket.accept();
            Runnable task = ()->handlerRequest(connect);
            exec.execute(task);
        }
    }

    private static void handlerRequest(Socket connect) {

    }
}
