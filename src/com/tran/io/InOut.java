package com.tran.IO;

import java.util.Scanner;

/**
 * @Time: 19-10-13下午3:33
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class InOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get first name
        System.out.println("what is your name");
        String name = scanner.nextLine();

        //get second name
        System.out.println("what is your last name");
        String last = scanner.nextLine();

        //get age
        System.out.println("what is your age");
        int age = scanner.nextInt();

        //hasNextInt()
        System.out.println("检测hasnextInt()");
        boolean bo = scanner.hasNextInt();
        //display console
        System.out.println("hello" + name + last + "next year you will be " + (age + 1) + bo);

    }
}
