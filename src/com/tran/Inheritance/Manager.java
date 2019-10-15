package com.tran.Inheritance;

/**
 * @Time: 19-10-15上午9:53
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Manager extends Employee{
    private double bonus;

    /**
     *
     * @param name
     * @param salary
     * @param year
     * @param month
     * @param day
     */
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double b){
        bonus = b;
    }
}
