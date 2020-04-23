package com.train.concurrent.procon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Time: 2020/4/22上午8:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LockConditionModel implements Model {
    private final Lock BUFFER_LOCK = new ReentrantLock();
    private final Condition BUFFER_COND = BUFFER_LOCK.newCondition();
    private int integer;
    private Queue<Task> buffer = new LinkedList<>();
    private int cap;

    public LockConditionModel(int cap){
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

    public class ProducerImpl extends AbstractProducer implements Producer, Runnable{

        @Override
        public void produce() throws InterruptedException {
            Thread.sleep((long) (500 + (Math.random() * 1000)));
            BUFFER_LOCK.lockInterruptibly();
            try{
                while (buffer.size() == cap){
                    BUFFER_COND.await();
                }
                Task task = new Task(integer++);
                buffer.offer(task);
                System.out.println("produce: "+ task.getNo());
                BUFFER_COND.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                BUFFER_LOCK.unlock();
            }
        }
    }

    public class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable{

        @Override
        public void consume() throws InterruptedException {
            BUFFER_LOCK.lockInterruptibly();
            try{
                while (buffer.size() == 0){
                    BUFFER_COND.await();
                }
                Task task = buffer.poll();
                assert task != null;
                System.out.println("consume: " + task.getNo());
                BUFFER_COND.signalAll();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                BUFFER_LOCK.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Model model = new LockConditionModel(3);
        for (int i = 0; i < 3; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
