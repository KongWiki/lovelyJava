package com.train.concurrent.status;

/**
 * @Time: 20-2-21下午8:33
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */

// 建议使用标志位 ---> 设置标志位
// 建议线程正常停止 ---> 利用次数 不建议使用死循环
// 不要使用stop 或者 destory等过时的方法
public class TestStatus  implements Runnable{
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run......Thread" + i++);
        }
    }

    //2 设置一个公共的方法停止线程 转换标志位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStatus status = new TestStatus();
        new Thread(status).start();

        for (int i = 0; i < 500; i++) {
            System.out.println("main" + i);
            if (i == 300){
                status.stop();
                System.out.println("线程停止");
            }
        }

    }
}


