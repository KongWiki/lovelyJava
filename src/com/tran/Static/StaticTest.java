package com.tran.Static;

import java.time.LocalDate;

/**
 * @Time: 19-10-14下午3:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */


class Employee {
    // 实例域
    private String name;
    private double salary;
    private int id;
    // 静态域
    private static int nextId = 1;
    // 构造器 与类同名
    // 在构造该类对象的时候，构造器就会运行 以便将实例域初始化为所希望的状态
    // 与类的其他方法不同的是 构造器总是伴随着new操作符的执行被调用
    // 而不能对一个已经存在的对象调用构造器来达到重新设置实例域的目的

    /**
     * 构造器与类同名
     * 每个类可以有一个及以上构造器
     * 构造器可以有0个、1个或多个参数
     * 构造器没有返回值
     * 构造器总是伴随new操作一起调用
     * 所有的方法中不要命名与实例域同名的变量
     */
    public Employee(String n, double s) {
        name = n;
        salary = s;


    }

    //访问器方法， 只返回实例域值，因此称为域访问器


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId += 1;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public static void main(String[] args) {
        Employee e = new Employee("harry", 15000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}


public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Tome", 5000);
        staff[1] = new Employee("Dick", 16000);
        staff[2] = new Employee("Harry", 17000);

        for (Employee e : staff) {
            e.setId();
            System.out.println("name=" + e.getName() + ", id= " + e.getId() + ", salary=" + e.getSalary());
        }
        int n = Employee.getNextId();
        System.out.println("Next available id= " + n);
    }
}