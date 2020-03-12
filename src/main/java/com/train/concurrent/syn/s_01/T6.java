package com.train.concurrent.syn.s_01;

import java.util.concurrent.TimeUnit;

/**
 * @Time: 20-3-5下午5:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 一个同步方法调用另一个同步方法 一个方法已经拥有某个对象的锁
// 再次申请的时候任然会获取该对象的锁
// 表明 synchronized获得的锁是可以重入的（获得锁之后还可以再获取一遍）
// 子类调用父类的同步方法
public class T6 {
    synchronized void m() {
        System.out.println(" m start ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" m end ");
    }

    public static void main(String[] args) {
        new TT().m();
    }
}

class TT extends T6 {
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
