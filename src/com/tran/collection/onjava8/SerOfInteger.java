package com.tran.collection.onjava8;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Time: 19-12-12下午9:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SerOfInteger {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> inset = new HashSet<>();
        for (int i = 0; i< 10000; i++) {
            inset.add(random.nextInt(30));
        }
        System.out.println(inset);
    }
}
