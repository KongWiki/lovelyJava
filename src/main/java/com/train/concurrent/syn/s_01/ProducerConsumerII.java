package com.train.concurrent.syn.s_01;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Time: 20-3-12上午11:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ProducerConsumerII<T> {
    private LinkedList<T> list = new LinkedList<>();
    private int count = 0;
    private int max = 20;
    private Lock lock = new ReentrantLock();

    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();




    public void product(T t){
        try{
            lock.lock();
            while (list.size() == max){
                producer.await();
            }
            list.add(t);
            count ++;
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }

    }

    public T consumer(){
        T t = null;
        try{
            lock.lock();
            while (list.size() == 0){
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
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
