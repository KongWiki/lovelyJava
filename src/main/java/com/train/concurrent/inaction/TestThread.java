package com.train.concurrent.inaction;

/**
 * @Time: 20-2-21上午9:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TestThread {
    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

//        while (!teemo.isDead()){
//            gareen.attack(teemo);
//        }
//        while (!leesin.isDead()){
//            bh.attack(leesin);
//        }

        KillThread killThread = new KillThread(gareen, teemo);
        killThread.start();
        KillThread killThread1 = new KillThread(bh, leesin);
        killThread1.start();
    }
}
