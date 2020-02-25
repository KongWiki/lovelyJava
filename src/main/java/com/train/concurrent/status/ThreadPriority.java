package com.train.concurrent.status;

/**
 * @Time: 20-2-21下午10:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "--->" +Thread.currentThread().getPriority());
        MyPriority priority = new MyPriority();
        Thread thread1 = new Thread(priority);
        Thread thread2 = new Thread(priority);
        Thread thread3 = new Thread(priority);
        Thread thread4 = new Thread(priority);
        Thread thread5 = new Thread(priority);
        Thread thread6 = new Thread(priority);
        thread1.setPriority(1);
        thread1.start();

        thread2.setPriority(4);
        thread2.start();

        thread3.setPriority(5);
        thread3.start();



        thread5.setPriority(8);
        thread5.start();

        thread6.setPriority(Thread.MAX_PRIORITY);
        thread6.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" +Thread.currentThread().getPriority());
    }
}
