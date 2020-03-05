package com.train.generic;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-3-5上午8:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class NoGenericsDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("abc");
        list.add(11);
        list.add(new double[] {1.0, 2.0});
        Object o1 = list.get(0);
        Object o2 = list.get(1);
        Object o3 = list.get(2);
        System.out.println("o1 = [ " + o1 + " ]");
        System.out.println("o2 = [ " + o2 + " ]");
        System.out.println("o3 = [ " + o3 + " ]");

    }
}
