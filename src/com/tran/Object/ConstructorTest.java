package com.tran.Object;

import java.util.Random;

/**
 * @Time: 19-10-14下午9:28
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Employee[]  staff = new Employee[3];

        staff[0] = new Employee("harry", 4000);
        staff[1] = new Employee(6000);
        staff[2] = new Employee();

        for(Employee e: staff){
            System.out.println("name="+e.getName()+",id="+e.getId()+",salary="+e.getSalary());
        }
    }
}


class Employee{
    //静态域
    private static int nextId;
    // 实例域
    private int id;
    private String name = "";
    private double salary;

    // 初始化块 静态的初始化块
    static{
        Random generator = new Random();
        nextId = generator.nextInt();
    }

    // 初始化块
    {
        id = nextId;
        nextId ++;
    }

    //三个重载构造器
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public Employee(double s){
        this("Employee #" +nextId, s);
    }

    public Employee(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
