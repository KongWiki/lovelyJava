package com.tran.Interfaces;

/**
 * @Time: 19-10-15下午5:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public void raiseSlary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }



    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }
}