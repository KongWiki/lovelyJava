package com.train.concurrent.pool;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;
import com.train.concurrent.pool.communication.Notify;
import com.train.concurrent.syn.s_01.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.nio.ch.ThreadPool;

import java.sql.Time;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Time: 2020/4/24下午4:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 自己手写一线程池
public class PoolByMySelf {
    private final static Logger LOGGER = LoggerFactory.getLogger(PoolByMySelf.class);
    private final ReentrantLock lock = new ReentrantLock();

    // 5个核心参数
    // 核心线程数量
    private volatile int corePoolSize;
    // 最大线程数量
    private volatile int maxPoolSize;
    // 最长闲置时间
    private long keepAliveTime;
    // 时间类型
    private TimeUnit unit;
    // 阻塞队列
    private volatile BlockingQueue<Runnable> workerQueue;

    //2个非核心参数
    private ThreadFactory threadFactory;

    private RejectedExecutionHandler handler;

    // 是否关闭线程标志
    private AtomicBoolean isShutDown = new AtomicBoolean(false);

    // 提交到线程池中的任务总数
    private AtomicInteger totalTask = new AtomicInteger();

    // 线程池任务全部执行完毕的通知组件
    private Object shutDownNotify = new Object();

    private Notify notify;



    // 存放线程池
    private volatile Set<Worker> workers;


    public PoolByMySelf(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workerQueue, Notify notify){
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.workerQueue = workerQueue;
        this.notify = notify;

        workers  = new ConcurrentSkipListSet<>();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        FutureTask<T> future = new FutureTask(callable);
        execute(future);
        return future;
    }

    private void execute(Runnable runnable) {
        if(runnable == null){
            throw new NullPointerException("runnable nullPointerException");
        }
        if(isShutDown.get()){
            LOGGER.info("线程池已经关闭，不能提交任务");
        }
        totalTask.incrementAndGet();
        if(workers.size() < corePoolSize){
            addWorker(runnable);
            return;
        }

        boolean offer = workerQueue.offer(runnable);
        if(!offer){
            // 如果小于最大线程数量
            if(workers.size() < maxPoolSize){
                addWorker(runnable);
                return;
            }else {
                LOGGER.error("超过最大线程池最大数量");
                try{
                    workerQueue.put(runnable);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void addWorker(Runnable runnable) {
        Worker worker = new Worker(runnable, true);

    }


    private final class Worker extends Thread{
        private Runnable task;

        private Thread thread;
        /**
         * true --> 创建新的线程执行
         * false --> 从队列里获取线程执行
         */
        private boolean isNewTask;

        public Worker(Runnable task, boolean isNewTask){
            this.task = task;
            this.isNewTask = isNewTask;
            thread = this;
        }

        @Override
        public void run() {
            super.run();
        }
    }




}
