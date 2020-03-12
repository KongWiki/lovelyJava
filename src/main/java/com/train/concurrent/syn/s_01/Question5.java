package com.train.concurrent.syn.s_01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Time: 20-3-5下午6:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Question5 {
    AtomicInteger count = new AtomicInteger(0);
    void m(){
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet(); // count ++ 其具备原子性
        }
    }

    public static void main(String[] args) {
        Question5  question5 = new Question5();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(()->question5.m(), "Thread-" + 1));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(question5.count);
    }

}

