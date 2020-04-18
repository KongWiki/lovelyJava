package com.train.concurrent.syn.learn;

/**
 * @Time: 20-4-18下午4:11
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// synchronized的可重入性
public class ReentranDemo extends ReentranFather{
    public synchronized void m1(){
        System.out.println("同类加锁方法");
    }

    @Override
    public synchronized void say() {
        System.out.println("我是子类方法");
        super.say();
    }

    public static void main(String[] args) {
        ReentranDemo demo = new ReentranDemo();
        Thread thread = new Thread(() -> {
            demo.say();
        });
        
    }
}

class ReentranFather{
    public synchronized void say(){
        System.out.println("我是父类方法");
    }
}
