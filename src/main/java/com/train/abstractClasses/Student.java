package com.train.abstractClasses;

/**
 * @Time: 19-10-15下午12:28
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Student extends Person {
    private String major;


    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
