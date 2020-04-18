package com.train.concurrent.vola;

/**
 * @Time: 20-4-18上午9:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class GoalNotifier implements Runnable{
    private volatile boolean goal = false;

    public boolean isGoal() {
        return goal;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    @Override
    public void run() {
        while (true){
            if(goal){
                System.out.println("Goal!!!!");

                setGoal(false);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        GoalNotifier notifier = new GoalNotifier();
        Thread thread = new Thread(notifier);

        thread.start();

        Thread.sleep(200);
        notifier.setGoal(true);
    }
}
