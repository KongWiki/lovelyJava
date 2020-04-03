package com.train.concurrent.status;

/**
 * @Time: 20-4-3上午8:41
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(()-> {});
        System.out.println(thread.getState());
        thread.start();
        thread.start();
        System.out.println(thread.getState());
    }
}
