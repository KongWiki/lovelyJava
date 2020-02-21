package com.train.jvm.classloader;

/**
 * @Time: 20-2-19上午9:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Tester2 {
    static {
        System.out.println("静态初始块被执行了！");
    }

    public Tester2(){}
}
