package com.tran.collection.arrayList;

import java.util.Arrays;

/**
 * @Time: 19-11-8下午9:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SorceForKnow {
    public static void main(String[] args) {
        int a  = 100;
        System.out.println(a >> 1);
        System.out.println(Integer.MAX_VALUE - 8);
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOf(arr1, 2);
        int[] arr3 = Arrays.copyOf(arr1, 10);
        for(int b : arr2){
            System.out.print(b + "");
        }

        for(int b: arr3){
            System.out.print(b+ "");
        }
    }

}
