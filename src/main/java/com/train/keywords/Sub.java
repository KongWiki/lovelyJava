package com.train.keywords;

/**
 * @Time: 20-2-20下午5:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Sub extends Super {

    public void subShow(){
        super.age = 100;
        super.name = "看看";
    }
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.subShow();
        sub.show();
    }
}
