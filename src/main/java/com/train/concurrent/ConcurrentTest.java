package com.train.concurrent;

import javax.swing.plaf.IconUIResource;

/**
 * @Time: 2020/5/27下午4:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConcurrentTest {
    private static final long COUNT = 1000001;


    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < COUNT; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency : " + time + "ms, b = " + b);
    }

    public static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + "ms, b = " + b);
    }

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
}
