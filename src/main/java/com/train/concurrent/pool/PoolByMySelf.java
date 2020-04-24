package com.train.concurrent.pool;

import com.train.concurrent.pool.communication.Notify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


    private final class Worker extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }

}
