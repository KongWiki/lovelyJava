package com.train.concurrent.syn;

/**
 * @Time: 2020/4/19下午9:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SyncTest {
    public void syncBlock(){
        synchronized (this){
            System.out.println("hello block");
        }
    }

    public synchronized void syncMethod(){
        System.out.println("hello block");
    }
}
