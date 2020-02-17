package com.train.jvm;

/**
 * @Time: 20-2-17下午10:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Memory {
    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 默认情况下：
        // 分配的内存为 系统总内存的1/4
        // 初始化内存为 系统总内存的1/64
        System.out.println("最大内存： " + l / 1024 / 1024 + "MB");
        System.out.println("最小内存： " + totalMemory / 1024 / 1024 + "MB");
    }
}
