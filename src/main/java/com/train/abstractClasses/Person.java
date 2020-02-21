package com.train.abstractClasses;

/**
 * @Time: 19-10-15上午11:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public abstract class Person {
    public abstract String getDescription();
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}


