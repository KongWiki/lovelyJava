package com.train.concurrent.procon;

import org.junit.internal.runners.statements.RunAfters;

/**
 * @Time: 2020/4/21下午8:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
