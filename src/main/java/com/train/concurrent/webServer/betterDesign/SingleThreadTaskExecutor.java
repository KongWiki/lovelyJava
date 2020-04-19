package com.train.concurrent.webServer.betterDesign;

import java.util.concurrent.Executor;

/**
 * @Time: 20-4-18下午10:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SingleThreadTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
