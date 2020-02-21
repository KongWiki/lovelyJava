package com.train.concurrent;

/**
 * @Time: 20-2-21上午11:07
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        // run 方法
        for (int i = 0; i < 20; i++) {
            System.out.println("run方法" + (i+1));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程对象
        ExtendsThread thread = new ExtendsThread();
        // 调用start()方法 开启线程
        thread.start();

        // main线程 主线程
        for (int i = 0; i < 200; i++) {
            System.out.println("main方法" + (i+1));
        }
    }
}
