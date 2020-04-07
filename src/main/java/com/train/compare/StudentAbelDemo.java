package com.train.compare;

/**
 * @Time: 20-4-4上午11:41
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class StudentAbelDemo implements Comparable<StudentAbelDemo> {
    private String name;
    private int age;

    public StudentAbelDemo( String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentAbelDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(StudentAbelDemo o) {
        return this.getAge() - o.getAge();
    }

    public static void main(String[] args) {
        StudentAbelDemo student1 = new StudentAbelDemo( "wkk1", 12);
        StudentAbelDemo student2 = new StudentAbelDemo("wkk2", 16);
        StudentAbelDemo student4 = new StudentAbelDemo("wkk3", 19);
        StudentAbelDemo student3 = new StudentAbelDemo("wkk4", 10);


    }
}
