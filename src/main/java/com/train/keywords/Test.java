package com.train.keywords;

/**
 * @Time: 20-2-20下午5:12
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Test {
    public static  int age;
    public static String name = "维坤坤";
    public Test() {
        System.out.print("默认构造方法！--");
    }

    // 非静态代码块
    {
        System.out.print("非静态代码块！--");
    }
    // 静态代码块
    static {
        System.out.print("静态代码块！--");
    }

    public static void test() {
        System.out.print("静态方法中的内容! --");
        {
            System.out.print("静态方法中的代码块！--");
        }

    }
    public static void main(String[] args) {

        Test test = new Test();
        Test.test();
    }
}
