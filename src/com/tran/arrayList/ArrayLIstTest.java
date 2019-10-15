package com.tran.arrayList;

import com.tran.Inheritance.Employee;

import java.util.ArrayList;

/**
 * @Time: 19-10-15下午4:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ArrayLIstTest {

    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("carl", 7500, 1987, 12,15));
        staff.add(new Employee("wkk", 15000, 1996, 12,2));
        staff.add(new Employee("hhh", 20000, 1997, 2,14));

        for(Employee e: staff){
            System.out.println("name="+ e.getName() + ", salary="+e.getSalary()+", hireday="+e.getHirday());
        }

    }
}
