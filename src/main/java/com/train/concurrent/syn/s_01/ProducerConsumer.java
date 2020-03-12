package com.train.concurrent.syn.s_01;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Time: 20-3-12上午10:46
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ProducerConsumer<T> {
    // 共享资源 list
    private LinkedList<T> list = new LinkedList<>();
    private int MAX = 10;
    private int count = 0;
    public synchronized void product(T t){
        while (list.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        this.notifyAll();
    }

    public synchronized T consumer(){
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        T t = list.removeFirst();
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        ProducerConsumer<String> resource = new ProducerConsumer<>();
        // 2个生产者 10个消费者
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 5; i1++) {
                    System.out.println(resource.consumer());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 25; i1++) {
                    resource.product(Thread.currentThread().getName() + " " + i1);
                }
            }, "p" + i).start();
        }
    }
}
