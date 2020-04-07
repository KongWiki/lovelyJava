package com.train.concurrent.commu;

/**
 * @Time: 20-4-3下午6:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Demo {
    private static Object lock = new Object();
    static class A implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for (int i = 0; i < 5; i++) {
                    System.out.println("A:" + i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class B implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                for (int i = 0; i < 5; i++) {
                    System.out.println("B:" + i);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new A()).start();
        Thread.sleep(1000);
        new Thread(new B()).start();


    }
}
