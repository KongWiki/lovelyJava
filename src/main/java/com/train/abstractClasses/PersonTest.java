package com.train.abstractClasses;

/**
 * @Time: 19-10-15上午11:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        people[0] = new Employee("har", 15000, 1999, 10,1);
        people[1] = new Student("wkk", "cs");
        for(Person p: people){
            System.out.println(p.getName()+", "+ p.getDescription());
        }

    }
}
