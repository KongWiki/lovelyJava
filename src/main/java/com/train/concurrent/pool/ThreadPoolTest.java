package com.train.concurrent.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Time: 2020/4/23下午12:03
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreadPoolTest implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue(5);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 16; i++) {
            threadPool.execute(
                    new Thread(new ThreadPoolTest(), "Thread".concat(i + " ")));
            System.out.println("线程池中活跃的线程数量: "+ threadPool.getPoolSize());
            if(queue.size() > 0){
                System.out.println("----------------队列中阻塞的线程数" + queue.size());
            }
        }
        threadPool.shutdown();
    }
}
