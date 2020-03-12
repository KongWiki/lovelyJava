package com.train.concurrent.syn.s_01;

/**
 * @Time: 20-3-5下午2:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// synchronized(this)的简写
public class T3 {
    private int count = 10;

    // 等同于在方法的代码执行时要synchronized(this)
    public synchronized void m(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count= " +count);
    }
}
