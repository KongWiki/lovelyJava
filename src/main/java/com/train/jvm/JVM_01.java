package com.train.jvm;

/**
 * @Time: 20-3-14上午11:21
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class JVM_01 {
    public static void main(String[] args) {
        JVM_01 jvm01 = new JVM_01();
        jvm01.m5();

    }
    public void m1(){
        int i = 200;
    }
    public void m2(int k ){
        int i = 300;
    }
    public void add(int a, int b){
        int i = a + b;
    }
    public void m3(){
        Object o = null;
    }
    public void m4(){
        Object o = new Object();
    }

    public void m5(){
        int i = 100;
        i = i++;
        System.out.println(i);
    }
}
