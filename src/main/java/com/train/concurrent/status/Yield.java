package com.train.concurrent.status;

import com.train.conclusion.SortUtils;

/**
 * @Time: 20-2-21下午9:47
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 测试礼让线程 礼让不一定成功
// 核心还是cpu
public class Yield {
    public static void main(String[] args) {
        MyYeild yeild = new MyYeild();

        new Thread(yeild, "a").start();
        new Thread(yeild, "b").start();
    }

}

class MyYeild implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始");
        Thread.yield();// 礼让线程
        System.out.println(Thread.currentThread().getName() + "线程停止");
    }
}
