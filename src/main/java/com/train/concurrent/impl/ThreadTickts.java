package com.train.concurrent.impl;


/**
 * @Time: 20-2-21下午2:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 多个线程操作用一个资源 会发生数据的紊乱(线程不安全)
public class ThreadTickts implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (tickets >=0) {
                System.out.println(Thread.currentThread().getName() + "---> 拿了第" + tickets-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        ThreadTickts tickts = new ThreadTickts();
        new Thread(tickts, "维坤坤").start();
        new Thread(tickts, "韩欢欢").start();
        new Thread(tickts, "孔维坤").start();

    }
}
