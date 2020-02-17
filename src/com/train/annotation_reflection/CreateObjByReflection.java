package com.train.annotation_reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Time: 20-2-5下午8:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 动态创建对象
public class CreateObjByReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 获取class对象
        Class aClass = Class.forName("com.train.annotation_reflection.User");
        // 构造一个对象
//        Object user = aClass.newInstance(); //本质是调用了类的无参构造器
//        System.out.println(user);
        // 通过构造器创建对象
//        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, int.class);
//        User user1 = (User) declaredConstructor.newInstance("孔维坤", 1, 24);
//        System.out.println(user1.getId());

        // 通过反射获取普通方法
        User user = (User) aClass.newInstance();
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        // invoke: 激活
        // (对象, "方法的值")
        setName.invoke(user, "维坤坤");
        System.out.println(user.getName());

        System.out.println("###############################");
        //反射操作属性
        User user3 = (User) aClass.newInstance();
        Field name = aClass.getDeclaredField( "name");
        // 不能操作私有属性 需要关闭安全检测
        name.setAccessible(true);
        name.set(user3, "孔维坤");
        System.out.println(user3.getName());



    }
}
