package com.train.concurrent.lock;

import com.train.concurrent.aqs.Mutex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Time: 2020/5/30下午4:58
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReentraLockTest {
    static class Context {
        Lock lock = new ReentrantLock();
        Lock lock1 = new Mutex();

        public void operation() {
            lock1.lock();
            System.out.println("原子操作" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }
    }

    static class MyThread implements Runnable{
        Context  context = new Context();
        public MyThread(Context context){
            this.context = context;
        }
        @Override
        public void run() {
            context.operation();
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.submit(new MyThread(context));
        }


    }
}
