package com.tran.generic;

/**
 * @Time: 19-12-12下午5:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
class Automobile{}


public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) {this.a = a;}
    Automobile get(){
        return a;
    }
}

