package com.tran.for50;

/**
 * @Time: 19-10-16下午6:06
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Proj01 {
    /**
     * 斐波那契
     * @param args
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println("第"+n+"个月的兔子总数为"+fun(n));
    }

    public static int fun(int n){
        if(n <= 2){
            return 1;
        }
        else {
            return fun(n-1) + fun(n-2);
        }
    }
}
