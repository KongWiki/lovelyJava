package com.tran.annotation_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Time: 20-2-5下午10:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */

// 性能测试
public class Performance {
    // 普通的调用
    public static void test01(){
        User user = new User();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long end = System.currentTimeMillis();
        System.out.println("普通调用共耗时: " + (end - start));
    }
    // 通过反射进行调用
    public static void test02() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
        Method getName = userClass.getDeclaredMethod("getName", null);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射调用共耗时: " + (end - start));

    }
    // 反射方式调用 关闭检测
    public static void test03() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
        Method getName = userClass.getDeclaredMethod("getName");
        getName.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射关闭检测后调用共耗时: " + (end - start));

    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        test01();
        test02();
        test03();
    }
}
