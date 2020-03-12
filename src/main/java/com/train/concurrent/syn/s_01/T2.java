package com.train.concurrent.syn.s_01;

import javax.management.relation.RoleUnresolved;

/**
 * @Time: 20-3-5下午2:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 可不创建一个对象 专门用于锁 锁定自身即可
public class T2 implements Runnable {
    private int count = 10;

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count= " + count);
        }
    }

    @Override
    public void run() {
        m();
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        for (int i = 0; i < 8; i++) {
            new Thread(t2).start();
        }

    }
}
