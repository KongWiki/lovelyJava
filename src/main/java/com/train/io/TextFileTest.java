package com.train.io;

import com.train.interfaces.Employee;

import java.io.*;
import java.util.Scanner;

/**
 * @Time: 19-12-28上午11:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TextFileTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("car", 15000);
        staff[1] = new Employee("wkk", 15000);
        staff[2] = new Employee("kwk", 15000);

        // 写入文件
        try (PrintWriter out = new PrintWriter("employee.dat", "utf-8")) {
            writeData(staff, out);

        }
        // 读取文件
        try (Scanner in = new Scanner(new FileInputStream("employee.dat"), "utf-8")) {
            Employee[] newStaff = readData(in);
            for (Employee employee : newStaff) {
                System.out.println(employee.getName());

            }
        }

    }

    private static void writeData(Employee[] employees, PrintWriter out) throws IOException {
        out.println(employees.length);

        for (Employee employee : employees) {
            writeEmployee(out, employee);

        }


    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);

        }
        return employees;
    }

    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|");
    }

    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        return new Employee(name, salary);
    }

}
