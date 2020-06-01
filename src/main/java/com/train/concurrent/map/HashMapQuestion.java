package com.train.concurrent.map;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Time: 2020/5/31下午9:48
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class HashMapQuestion {
    private static final HashMap<String, String> map = new HashMap<>(2);

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), " ");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();

        System.out.println(map.keySet().size());
        
    }
}
