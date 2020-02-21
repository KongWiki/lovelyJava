package com.train.annotation_reflection;

/**
 * @Time: 20-2-5上午8:54
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@SuppressWarnings("all")
public class Annotation extends Object {

    // 重写父类
    @Override
    public String toString() {
        return "Anntation Class";
    }

    // 不推荐使用
    @Deprecated
    public static void test() {
        System.out.println("Deprecated方法");
    }

    public static void main(String[] args) {
        test();
        test1();
    }
    @SuppressWarnings("all")
    public static void test1(){
        System.out.println("SuppressWarnings方法");
    }


}
