package com.train.concurrent.syn.learn;

/**
 * @Time: 20-4-18上午10:50
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UnThreadSafeCountingProcessor implements CountingProcessor {
    private long count = 0;
    @Override
    public void process() {
        doProcess();
        count++;

    }

    private void doProcess() {

    }

    @Override
    public long getCount() {
        return count;
    }
}
