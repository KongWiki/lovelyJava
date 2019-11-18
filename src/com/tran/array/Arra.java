package com.tran.array;

/**
 * @Time: 19-10-13下午4:40
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Arra {
    public static void main(String[] args) {
        int[] a = new int[20];
        for(int i=0; i<20; i++){
            a[i] = i+50;
        }

        int[] b = {1,3,4,566,543,432,52,646};



        for(int element: a){
            System.out.println(element);
        }

    }
}
