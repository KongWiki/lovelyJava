package com.train.concurrent.inaction;

/**
 * @Time: 20-2-21上午10:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class KillThread extends Thread {

    private Hero hero1;
    private Hero hero2;

    public KillThread(Hero h1, Hero h2){
        this.hero1 = h1;
        this.hero2 = h2;
    }

    @Override
    public void run() {
        while (!hero2.isDead()){
            hero1.attack(hero2);
        }
    }
}
