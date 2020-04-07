package com.train.concurrent.vola;

/**
 * @Time: 20-4-3下午7:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class VolatileDemo {
    static int a = 0;
    static volatile boolean flag = false;

    public static void writer(){
        a = 1;
        flag = true;
    }


    public static void reader(){
        if(flag){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        writer();
        reader();
    }
}
