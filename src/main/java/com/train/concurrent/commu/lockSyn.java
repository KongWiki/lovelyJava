package com.train.concurrent.commu;

/**
 * @Time: 2020/4/19下午4:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class lockSyn {
    static class ThreadA implements Runnable{
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("ThreadA " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("ThreadB " + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();

    }
}
