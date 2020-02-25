package com.train.concurrent.status;

/**
 * @Time: 20-2-21下午10:02
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class StatusJudge {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("/////");
        });

        // 观测状态
        Thread.State  state = thread.getState();
        System.out.println(state);

        // 观测启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED){
            Thread.sleep(1000);
            state = thread.getState();
            System.out.println(state);
        }
    }
}
