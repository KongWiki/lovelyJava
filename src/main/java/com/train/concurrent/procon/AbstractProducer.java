package com.train.concurrent.procon;

/**
 * @Time: 2020/4/21下午8:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
abstract class AbstractProducer implements Runnable, Producer {
    @Override
    public void run() {
        while (true){
            try{
                produce();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
