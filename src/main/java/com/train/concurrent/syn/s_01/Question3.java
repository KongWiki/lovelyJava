package com.train.concurrent.syn.s_01;

import java.util.concurrent.TimeUnit;

/**
 * @Time: 20-3-5下午5:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 程序在执行时 出现异常 默认会释放锁
// 如在web中多个servlet访问同一个资源时！！！
public class Question3 {
    int count = 0;
    synchronized void m(){
        System.out.println(Thread.currentThread().getName() + " start ");
        while (true){
            System.out.println(Thread.currentThread().getName() + " count= " + count++);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(count == 10){
                int i = 1/0;
            }
        }
    }

    public static void main(String[] args) {
        Question3 t = new Question3();
        new Thread(()->t.m(), "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()-> t.m(), "t2").start();

    }
}
