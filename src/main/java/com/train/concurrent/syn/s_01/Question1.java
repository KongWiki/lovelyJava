package com.train.concurrent.syn.s_01;

/**
 * @Time: 20-3-5下午2:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 执行synchronized方法时可以同时执行其他的非synchronized方法
public class Question1 {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + " m1 start");
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();

        }
        System.out.println(Thread.currentThread().getName() + " m1 end ");
    }

    public void m2(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        Question1 t = new Question1();
        new Thread(()->t.m1(), "t1").start();
        new Thread(()->t.m2(), "t2").start();;
    }
}
