package com.train.string;

/**
 * @Time: 19-10-13下午3:10
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Enumerate {
    enum Size {SMALL , MEDIUM, LARGE, EXTRA_LARGE};

    public static void main(String[] args) {
        Size s = Size.EXTRA_LARGE;
        System.out.println(s);
    }
}
