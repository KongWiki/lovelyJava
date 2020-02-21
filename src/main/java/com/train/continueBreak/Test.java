package com.train.continueBreak;

/**
 * @Time: 19-12-6下午12:11
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Test {
    public static void main(String[] args) {
//        testBreak();
        testContinue();
//        testReturn();
    }

    static void testBreak() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("i=" + i);
            } else {
                System.out.println("执行了break语句,跳出当前循环!");
                break;
            }
        }
    }

    static void testContinue() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("没有执行continue语句输出i=" + i);
            } else {
                System.out.println("执行了Continue语句,跳出当前循环!");
                continue;
            }
        }
    }

    static void testReturn() {
        for (int i = 0; i < 10; i++) {
            System.out.println("执行了return语句,直接跳出了当前的testReturn方法!");
            return;
        }
    }
}
