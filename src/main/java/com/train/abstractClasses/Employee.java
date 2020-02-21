package com.train.abstractClasses;

import java.time.LocalDate;

/**
 * @Time: 19-10-15上午11:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Employee extends Person{
    private double salary;
    private LocalDate hirDay;

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hirDay = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHirDay() {
        return hirDay;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }
}

