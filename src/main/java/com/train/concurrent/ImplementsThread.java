package com.train.concurrent;

/**
 * @Time: 20-2-21下午2:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ImplementsThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run方法: " + i);
        }
    }

    public static void main(String[] args) {
        ImplementsThread myThread = new ImplementsThread();
        Thread thread = new Thread(myThread);
        thread.start();

    }
}
