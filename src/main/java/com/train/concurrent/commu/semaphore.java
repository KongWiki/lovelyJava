package com.train.concurrent.commu;

/**
 * @Time: 2020/4/19下午4:43
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class semaphore {
    private static volatile int signal = 0;

    static class ThreadA implements Runnable{

        @Override
        public void run() {
            while (signal < 10){
                if(signal % 2 == 0){
                    System.out.println("ThreadA: " + signal);
                    signal++;
                }
            }
        }
    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            while (signal < 10){
                if(signal % 2 == 1){
                    System.out.println("ThreadB: "+ signal);
                    signal++;
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
