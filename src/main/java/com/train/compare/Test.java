package com.train.compare;

/**
 * @Time: 20-4-4上午11:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Test {
    public static Comparable comparable(Comparable c1, Comparable c2) {
        int result = c1.compareTo(c2);
        return result >= 0 ? c1 : c2;
    }

    public static void main(String[] args) {
        StudentAbelDemo stundent1=  new StudentAbelDemo("维坤坤", 23);
        StudentAbelDemo stundent2=  new StudentAbelDemo("坤坤维", 25);
        Comparable max = comparable(stundent1, stundent2);
        System.out.println(max.toString());


    }
}
