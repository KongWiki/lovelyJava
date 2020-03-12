package com.train.concurrent.syn.s_01;

import java.util.concurrent.TimeUnit;

/**
 * @Time: 20-3-5下午6:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
//volatile和synchronized区别
public class Question4 {
   volatile boolean runnig = true;
    void m(){
        System.out.println(" m start");
        while (runnig){
        }
        System.out.println(" m end ");
    }

    public static void main(String[] args) throws InterruptedException {
        Question4 question4 = new Question4();
        new Thread(()->question4.m(), "4").start();
        TimeUnit.SECONDS.sleep(1);
        question4.runnig = false;

    }
}
