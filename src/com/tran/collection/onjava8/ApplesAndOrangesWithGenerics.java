package com.tran.collection.onjava8;

import java.util.ArrayList;

/**
 * @Time: 19-12-12下午7:04
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple > apples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        for (Apple apple : apples) {
            System.out.println(apple.id());

        }
    }
}
