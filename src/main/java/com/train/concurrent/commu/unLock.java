package com.train.concurrent.commu;

import javax.management.relation.RoleUnresolved;

/**
 * @Time: 2020/4/19下午4:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class unLock {
    static class ThreadA implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("ThreadA " + i);
            }
        }
    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadB " + i);

            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}
