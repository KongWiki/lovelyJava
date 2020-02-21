package com.train.jvm.classloader;

/**
 * @Time: 20-2-17上午11:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ClassLoaderKnow {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassLoaderKnow.class.getClassLoader());
        System.out.println(System.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        //
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

    }
}
