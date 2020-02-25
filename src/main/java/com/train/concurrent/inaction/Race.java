package com.train.concurrent.inaction;

/**
 * @Time: 20-2-21下午3:13
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Race implements Runnable {
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            if (Thread.currentThread().getName().equals("兔子") && i == 400) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "---> 跑了" + i + "步");
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
        }
    }

    public boolean gameOver(int i) {
        if(winner!=null){
            return true;
        }else {
            if(i >=1000){
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();

    }
}
