package com.train.jvm.classloader;

/**
 * @Time: 20-2-19上午9:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Tester2.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        // loadClass 不会加载静态代码块儿
        classLoader.loadClass("com.train.jvm.classloader.Tester2");
        // forName 默认会加载静态代码块儿
        Class.forName("com.train.jvm.classloader.Tester2");
        Class.forName("com.train.jvm.classloader.Tester2", false, classLoader);



    }
}
