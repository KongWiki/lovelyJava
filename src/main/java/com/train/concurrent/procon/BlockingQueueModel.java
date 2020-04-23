package com.train.concurrent.procon;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Time: 2020/4/21下午8:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BlockingQueueModel implements Model {
    private BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public BlockingQueueModel(int cap){
        this.queue = new LinkedBlockingDeque<>(cap);
    }


    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }

    private class ConsumerImpl extends AbstractConsumer implements Runnable, Consumer{

        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume: " + task.getNo());

        }
    }

    private class ProducerImpl extends AbstractProducer implements Runnable, Producer{
        @Override
        public void produce() throws InterruptedException {
            Thread.sleep((long) (500 + (Math.random()) * 1000));
            Task task = new Task(increTaskNo.getAndIncrement());
            System.out.println("produce: " + task.getNo());
            queue.put(task);
        }
    }

    public static void main(String[] args) {
        Model model = new BlockingQueueModel(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
