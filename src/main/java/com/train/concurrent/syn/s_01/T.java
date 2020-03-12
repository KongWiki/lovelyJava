package com.train.concurrent.syn.s_01;

/**
 * @Time: 20-3-5上午11:57
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 锁定一个对象 执行完之后释放
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m(){
        // 任何线程要执行下述代码 都需要先获得o的锁
        synchronized(o){
            count--;
            System.out.println(Thread.currentThread().getName() + "count = " +count);
        }
    }

    public static void main(String[] args) {

    }
}
