package com.train.concurrent.status;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Time: 20-4-3上午11:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */

public class StatusChangeTest {

    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        a.start();
        a.join();
//        Thread.sleep(1000);
        b.start();
        System.out.println(a.getName() + " " + a.getState());
        System.out.println(b.getName() + " " + b.getState());

    }

    @Test
    public void allTest(){
        Thread a = new Thread(()-> {});
        Thread b = new Thread(()-> {});
        System.out.println(a.getState());
        a.start();
        System.out.println(a.getState());
    }

    private synchronized void testMethod(){
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
