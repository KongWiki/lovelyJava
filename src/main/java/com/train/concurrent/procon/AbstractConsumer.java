package com.train.concurrent.procon;

/**
 * @Time: 2020/4/21下午8:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
abstract class AbstractConsumer implements Consumer, Runnable {
    @Override
    public void run() {
        while (true){
            try{
                consume();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
