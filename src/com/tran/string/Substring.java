package com.tran.string;

/**
 * @Time: 19-10-13下午3:12
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Substring {


    public static void main(String[] args) {
        String e = " ";
        String greeting = "Hello";
        // 子串
        System.out.println(greeting.substring(0, 3));
        String a = "好好";
        String b = "坏坏";
        String mesage = a + b;
        int age = 13;
        String rating = "PG" + age;
        System.out.println(mesage+e+rating);
        String c = "你好，我是维坤坤";
        greeting = greeting.substring(0, 3) + "p!";
        System.out.println(greeting);
        System.out.println();
        System.out.println(c.codePointAt(2));
        StringBuilder builder = new StringBuilder();
        builder.append("fsd");
        builder.append("--fsda");
        System.out.println(builder.toString().length());
    }
}
