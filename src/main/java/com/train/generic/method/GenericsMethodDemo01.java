package com.train.generic.method;

/**
 * @Time: 20-3-5上午9:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class GenericsMethodDemo01 {
    public static <T> void printClass(T obj){
        System.out.println(obj.getClass().getName());
    }

    public static void main(String[] args) {
        printClass("3254");
        printClass(21454);

    }
}
