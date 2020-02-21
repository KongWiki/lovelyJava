package com.train.annotation_reflection;

/**
 * @Time: 20-2-5下午5:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Person {
    public String name;
    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
