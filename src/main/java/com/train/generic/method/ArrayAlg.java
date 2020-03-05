package com.train.generic.method;

import java.io.Serializable;

/**
 * @Time: 20-3-5上午10:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ArrayAlg {
    public static <T> T getMiddle(T[] a){
        if(a==null || a.length ==0){
            return null;
        }
        T smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            if(smallest.)
        }
        return a[a.length/2];
    }

    public static void main(String[] args) {
        String middle = ArrayAlg.getMiddle("Jhone", "Q", "Public");
        System.out.println(middle);
        Integer middle1 = ArrayAlg.getMiddle(1, 2, 3, 4);
        System.out.println(middle1);

        Number middle2 = ArrayAlg.getMiddle(3.15, 24, 35, 34.432);
        System.out.println(middle2);

        Serializable middle3 = ArrayAlg.getMiddle("124", 21, null);
        System.out.println(middle3);

    }
}
