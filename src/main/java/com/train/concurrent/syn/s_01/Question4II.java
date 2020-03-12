package com.train.concurrent.syn.s_01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-3-5下午6:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Question4II {
    volatile int count = 0;
    void m(){
        for (int i = 0; i < 10000; i++) {
            count ++;
        }
    }

    public static void main(String[] args) {
        Question4II question9 = new Question4II();
        List<Thread> threads = new ArrayList<>();
        for (int t = 0; t < 10; t++) {
            threads.add(new Thread(()->question9.m(), "Thread-" + t));
        }
        threads.forEach((o)-> o.start());
        threads.forEach((o) ->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(question9.count);

    }
}
