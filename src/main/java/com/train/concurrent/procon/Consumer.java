package com.train.concurrent.procon;


/**
 * @Time: 2020/4/21下午6:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface Consumer {
    void consume() throws InterruptedException;
}
