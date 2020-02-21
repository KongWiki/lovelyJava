package com.train.interfaces;

import java.util.Arrays;

/**
 * @Time: 19-10-15下午5:21
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class EmployeeSortTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("harry", 100000);
        staff[1] = new Employee("wkk", 15000);
        staff[2] = new Employee("hhh", 20000);

        Arrays.sort(staff);

        for(Employee e: staff){
            System.out.println("name="+e.getName()+", salary="+e.getSalary());
        }
    }

}
