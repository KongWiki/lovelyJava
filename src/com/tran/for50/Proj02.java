package com.tran.for50;

/**
 * @Time: 19-10-16下午7:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Proj02 {
    /**
     * 101-200包含多少素数
     */
    public static void main(String[] args) {
        int count = 0;
        for(int i=101; i<201; i++){
            boolean flag = isPrime(i);
            if(flag){
                count += 1;
            }
        }
        System.out.println("素数的个数为"+count);
    }

    public static boolean isPrime(int n){
        boolean flag = true;
        for(int j=2; j< Math.sqrt(n); j++){
            if(n%j == 0){
                flag = false;
            }

        }
        return flag;
    }
}
