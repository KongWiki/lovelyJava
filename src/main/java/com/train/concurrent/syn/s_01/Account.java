package com.train.concurrent.syn.s_01;

import java.util.concurrent.TimeUnit;

/**
 * @Time: 20-3-5下午3:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 业务写方法加锁
// 业务读方法不加锁
// 容易产生数据的脏读
public class Account {
    private String name;
    private Double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public Double getBalance(String name) {
        return balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(() -> account.set("wkk", 100)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("第一次num -> " + account.getBalance("wkk"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("第二次num -> " + account.getBalance("wkk"));
    }


}
