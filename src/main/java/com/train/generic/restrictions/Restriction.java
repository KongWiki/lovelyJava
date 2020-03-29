package com.train.generic.restrictions;

import java.util.List;

/**
 * @Time: 20-3-5上午11:38
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Restriction {
    public static <T> void append(List<T> list, Class<T> cls) throws IllegalAccessException, InstantiationException {
        // 2. 无法创建类型参数实例
//        T t = new T();
        T t = cls.newInstance();


    }

    public static void main(String[] args) {
        // 1. 不能使用基础类型（int, long ...）替代K V
//        Pair<int, char> p = new Pair<int, char>(2, 'a');
        Pair<Integer, Character> p = new Pair<>(1, 'a');
        p = new Pair<>(Integer.valueOf(1), Character.valueOf('a'));
        System.out.println(p);

    }
}
