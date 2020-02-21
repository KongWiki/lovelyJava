package com.train.jvm.classloader;

/**
 * @Time: 20-2-17下午2:02
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTree.class.getClassLoader();
        while (classLoader !=null){
            System.out.println("当前的classloader为： " +classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
