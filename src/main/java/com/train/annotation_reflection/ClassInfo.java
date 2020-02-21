package com.train.annotation_reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Time: 20-2-5下午7:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ClassInfo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        //获取类名
        Class aClass = Class.forName("com.train.annotation_reflection.User");
        System.out.println("getName(): " + aClass.getName());
        System.out.println("getSimpleName(): " + aClass.getSimpleName());

        //获取类的属性
        System.out.println("###############################");
        // 其只能找到public属性
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        //其能获取全部属性 无视public private
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("获取的类型属性： " + declaredField);
        }

        Field name = aClass.getDeclaredField("name");
        System.out.println("获取指定的属性值: " + name);

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("获取该类的所有方法"+method);
        }
        System.out.println();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for ( Method declaredMethod : declaredMethods) {
            System.out.println("获取该类自己声明的方法" + declaredMethod);

        }
        System.out.println("#################################################");
        // 获取指定的方法
        Method getName = aClass.getMethod("getName", null);
        Method setName = aClass.getMethod("setName", String.class);
        System.out.println("getName: "+ getName + "\n setName: " + setName);

        // 获得构造器
        System.out.println("###############################################");
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("####");
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        //获得指定构造器
        System.out.println("###############################################");
        Constructor constructor = aClass.getConstructor(null);
        System.out.println("constructor: " + constructor);
        Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("###");
        System.out.println(declaredConstructor);
        System.out.println("###");

        System.out.println("###################获取注解###############");
        // 获取注解
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }


    }
}
