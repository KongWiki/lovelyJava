package com.train.concurrent.vola;

import sun.font.TextRecord;

/**
 * @Time: 20-4-3下午7:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class VolatileDemo {
    boolean flag = false;

    public void writer() {
        flag = true;
    }


    public void reader() {
            if (flag) {
                System.out.println("flag = true");
            }
            else {
                System.out.println("flag=false");
            }

    }

    public static void main(String[] args) throws InterruptedException {

    }
}
