package com.tran.inheritance;

/**
 * @Time: 19-10-15上午9:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Cracker", 8000, 1987, 12, 15);
        boss.setBonus(500);

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("harry", 5000, 1985, 10,1);
        staff[1] = new Employee("jack", 6000, 1989, 11,1);
        staff[2] = new Employee("mike", 5600, 1990, 12,1);

        for(Employee e: staff){
            System.out.println("name="+e.getName()+", salary="+e.getSalary());

        }
    }
}
