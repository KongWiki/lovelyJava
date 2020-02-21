package com.train.Class;

import java.time.LocalDate;

/**
 * @Time: 19-10-13下午7:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
class Employee {
    // 实例域
    private String name;
    private double salary;
    private LocalDate hirday;
    private int id;
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
    public Employee(String n, double s, int year, int month, int day, int iden) {
        name = n;
        salary = s;
        hirday = LocalDate.of(year, month, day);
        id = iden;


    }

    //访问器方法， 只返回实例域值，因此称为域访问器
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHirday() {
        return hirday;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHirday(LocalDate hirday) {
        this.hirday = hirday;
    }

    public void setId() {
        this.id = nextId;
        nextId += 1;

    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }


}

public class EmployeeTest {
    public static void main(String[] args) {
//        Employee[] staff = new Employee[3];
//        staff[0] = new Employee("wkk", 15000, 2020, 6, 15, 1);
//
//        staff[1] = new Employee("孔维坤", 17000, 2021, 6, 15, 2);
//        staff[2] = new Employee("孔维坤II", 25000, 2022, 9, 15, 3);
//
//        for (Employee e : staff) {
//            System.out.println("name=" + e.getName() + ", Salary=" + e.getSalary() + ", hireDay=" + e.getHirday());
//            System.out.println();
//
//            e.raiseSalary(5);
//            System.out.println("name=" + e.getName() + ", Salary=" + e.getSalary() + ", hireDay=" + e.getHirday());
//        }
        Employee harry  = new Employee("harry", 22000, 1997, 2,14, 15);
        harry.setName("hanhuanhuan");
        harry.setId();
        System.out.println(harry.getId());

    }


}
