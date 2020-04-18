package com.train.concurrent.syn.learn;

/**
 * @Time: 20-4-18下午12:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SynchronizeBlockCountingProcessor implements CountingProcessor {
    private long count = 0;

    @Override
    public void process() {
        doProcess();
        synchronized (this){
            count++;
        }
    }

    private void doProcess() {

    }

    @Override
    public long getCount() {
        return count;
    }
}
