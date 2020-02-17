package com.train.inheritance;

import java.time.LocalDate;

/**
 * @Time: 19-10-15上午9:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Employee {
    // 实例域
    private String name;
    private double salary;
    private LocalDate hirday;

    public Employee(String name, double salary, int year , int month, int day){
        this.name = name;
        this.salary = salary;
        hirday = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHirday() {
        return hirday;
    }

    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }
}
