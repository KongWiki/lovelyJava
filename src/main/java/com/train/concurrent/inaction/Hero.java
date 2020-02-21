package com.train.concurrent.inaction;

/**
 * @Time: 20-2-21上午9:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Hero {
    public String name;
    public float hp;
    public int damage;

    public void attack(Hero hero){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        hero.hp -= damage;
        System.out.format("%s 攻击了 %s, %s的hp变成了%.2f \n", name, hero.name, hero.name, hero.hp);

        if(hero.isDead()){
            System.out.println(hero.name + "死了");
        }
    }

    public boolean isDead(){
        return 0>=hp?true:false;
    }
}
