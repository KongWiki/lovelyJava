package com.train.concurrent.webServer.betterDesign;

import java.util.concurrent.Executor;

/**
 * @Time: 20-4-18下午10:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
