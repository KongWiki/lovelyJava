package com.train.jvm;

/**
 * @Time: 20-2-17上午9:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class HelloJVM {
    public int name;

    // 双亲委派机制
    // 1 APP --> EXC --> BOOT(最终执行)
    // BOOT
    // EXC
    // APP
    public static void main(String[] args) {
        HelloJVM jvm1 = new HelloJVM();
        HelloJVM jvm2 = new HelloJVM();
        HelloJVM jvm3 = new HelloJVM();

        System.out.println(jvm1.hashCode());
        System.out.println(jvm2.hashCode());
        System.out.println(jvm3.hashCode());
        System.out.println("============================");
        Class<? extends HelloJVM> aClass = jvm1.getClass();
        // AppClassLoader
        System.out.println(aClass.getClassLoader());
        // ExtClassLoader  \jre\lib\ext
        System.out.println(aClass.getClassLoader().getParent());
        // null 1. 不存在 2. 获取不到 rt.jar
        System.out.println(aClass.getClassLoader().getParent().getParent());


    }
}
