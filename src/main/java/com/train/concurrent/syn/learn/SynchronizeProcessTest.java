package com.train.concurrent.syn.learn;

import org.junit.Test;

/**
 * @Time: 20-4-18上午10:52
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SynchronizeProcessTest {
    public static final int LOOP_TIME = 1000 * 10000;

    @Test
    public void test_UnThreadSafeCountingProcessor(){
        CountingProcessor processor = new UnThreadSafeCountingProcessor();
        runTask(processor);
    }


    @Test
    public void test_SynchronizeBlockCountingProcessor() {
        CountingProcessor countingProcessor = new SynchronizeBlockCountingProcessor();
        runTask(countingProcessor);
    }

    private void runTask(CountingProcessor processor) {
        Thread thread1 = new Thread(new ProcessTask(processor, LOOP_TIME), "thread-1");
        Thread thread2 = new Thread(new ProcessTask(processor, LOOP_TIME), "thread-2");

        thread1.start();
        thread2.start();
        // wait unit all the threads have finished
        while(thread1.isAlive() || thread2.isAlive()) {}
    }


}
