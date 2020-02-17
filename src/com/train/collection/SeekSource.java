package com.train.collection;

/**
 * @Time: 19-11-18下午12:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SeekSource {
    public static void main(String[] args) {
        int a = 28;
        printInfo(a);
        System.out.println(">>1");
        printInfo(a>>1);
        System.out.println(">>2");
        printInfo(a>>2);
        System.out.println(">>>3");
        printInfo(a>>>3);
        System.out.println(">>3");
        printInfo(a>>3);
        System.out.println();
        a = -28;
        printInfo(-28);
        printInfo(a>>>3);
    }


    /**
     * 用于测试
     * >> <<
     * >>>
     */
    private static void printInfo(int num){
        System.out.println(num + " 的二进制为: " + Integer.toBinaryString(num));
    }
}
