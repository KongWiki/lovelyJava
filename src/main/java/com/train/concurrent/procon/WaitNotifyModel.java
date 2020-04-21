package com.train.concurrent.procon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Time: 2020/4/22上午7:40
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WaitNotifyModel implements Model {
    private int integer;
    private final Object buffer_lock = new Object();
    private final Queue<Task> buffer = new LinkedList<>();
    private int cap;

    public WaitNotifyModel(int cap){
        this.cap = cap;
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    public class ProducerImpl extends AbstractProducer implements Runnable, Producer{

        @Override
        public void produce() throws InterruptedException {
            Thread.sleep((long) (500 + (Math.random() * 1000)));
            synchronized (buffer_lock){
                while (buffer.size() == cap){
                    buffer_lock.wait();
                }
                Task task = new Task(integer++);
                buffer.add(task);
                System.out.println("produce: " + task.getNo());
                buffer_lock.notifyAll();
            }
        }
    }

    public class ConsumerImpl extends AbstractConsumer implements Runnable, Consumer{

        @Override
        public void consume() throws InterruptedException {
            synchronized (buffer_lock){
                while (buffer.size() == 0){
                    buffer_lock.wait();
                }
                Task task = buffer.poll();
                assert task != null;
                Thread.sleep((long) (500 + (Math.random() * 1000)));
                System.out.println("consume: " + task.getNo());
                buffer_lock.notifyAll();

            }
        }
    }

    public static void main(String[] args) {
        Model model = new WaitNotifyModel(3);
        for (int i = 0; i < 3; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
 }
