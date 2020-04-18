package com.train.concurrent.syn.learn;

/**
 * @Time: 20-4-18上午10:49
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface CountingProcessor {
    void process();
    long getCount();

}
