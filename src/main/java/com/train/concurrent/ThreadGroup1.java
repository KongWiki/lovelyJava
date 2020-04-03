package com.train.concurrent;

/**
 * @Time: 20-4-3上午8:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreadGroup1 {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            System.out.println("thread当前的线程组为: " + Thread.currentThread().getThreadGroup().getName());
            System.out.println("thread的线程名字为: " + Thread.currentThread().getName());
        });
        thread.start();
        System.out.println("main方法的线程组为: " + Thread.currentThread().getThreadGroup().getName());
    }
}
