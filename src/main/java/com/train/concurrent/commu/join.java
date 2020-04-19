package com.train.concurrent.commu;

/**
 * @Time: 2020/4/19下午7:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class join {
    static class ThreadA implements Runnable{

        @Override
        public void run() {
            System.out.println("我是子线程，我先睡一秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是子线程，我睡好了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        thread.join();
        System.out.println("我是主线程，因为子线使用了join()，所以我等到他执行完才能执行");

    }
}
