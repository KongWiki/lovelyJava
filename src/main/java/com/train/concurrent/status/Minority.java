package com.train.concurrent.status;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Time: 20-2-21下午9:33
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Minority {

    public static void main(String[] args){
        Date startTime = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH-mm-ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0) {
                System.out.println("over!");
                break;
            }
        }
    }
}
