package com.train.concurrent.impl;

/**
 * @Time: 20-4-3上午8:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreadGroup2 {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup, "thread");
        thread.setPriority(9);
        System.out.println("线程组的级别: " + threadGroup.getMaxPriority());
        System.out.println("线程的级别: " + thread.getPriority());

    }
}
