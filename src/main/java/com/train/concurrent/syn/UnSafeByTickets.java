package com.train.concurrent.syn;

/**
 * @Time: 20-2-22上午8:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UnSafeByTickets {
    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();
        new Thread(ticket, "我").start();
        new Thread(ticket, "你").start();
        new Thread(ticket, "他").start();
        new Thread(ticket, "黄牛").start();
    }

}


class BuyTicket implements Runnable{
    private int num = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void buy() throws InterruptedException {
        if (num<=0){
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() +"买了第"+num-- + "票");

    }
}
