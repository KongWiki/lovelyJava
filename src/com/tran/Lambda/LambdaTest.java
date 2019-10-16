package com.tran.Lambda;


import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
/**
 * @Time: 19-10-15下午8:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earch", "Mars",
        "Jupiter", "Saturn", "Uranus", "Neptune"};

        System.out.println(Arrays.toString(planets));
        System.out.println("sorted in dictionary order:");
        Arrays.sort(planets);

        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length");

        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));


        Timer t = new Timer(1000, event -> System.out.println("The time is "+new Date()));
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}
