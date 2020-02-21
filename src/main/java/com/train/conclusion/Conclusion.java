package com.train.conclusion;

/**
 * @Time: 19-11-27下午4:06
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Conclusion {
    public static void main(String[] args) {
        System.out.println("###################Integer方面知识##################");
        Integer x = new Integer(125);
        Integer y = new Integer(125);
        System.out.println(x==y);
        Integer z = Integer.valueOf(125);
        Integer k = Integer.valueOf(125);
        System.out.println(k == z);
        System.out.println("###################Integer方面知识##################");
        Integer m = 124;
        Integer n = 124;
        System.out.println(m == n); // true 若是 m=129 n=129 错误
        System.out.println("#####################################");
        String a = "fass";

    }
}
