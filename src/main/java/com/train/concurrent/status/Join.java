package com.train.concurrent.status;

/**
 * @Time: 20-2-21下午9:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Join implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Join join = new Join();
        Thread thread = new Thread(join, "a");
        thread.start();
        for (int i = 0; i < 100; i++) {
            while ( i == 50){
                thread.join();// main 线程阻塞
            }
            System.out.println("main..." + i);
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("join..." + i);
        }
    }
}
