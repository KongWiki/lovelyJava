package com.train.keywords;

/**
 * @Time: 20-2-20下午5:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Super {
    protected int age;
    protected String name;

    public Super(){}

    public Super(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void show(){
        System.out.println("age= " + age + ", name= " + name );
    }
}
