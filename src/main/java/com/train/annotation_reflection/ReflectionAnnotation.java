package com.train.annotation_reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Time: 20-2-5下午10:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 练习反射操作注解
public class ReflectionAnnotation {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<People> peopleClass = People.class;
        // 获得注解
        Annotation[] annotations = peopleClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解的值
        MyannotationFinall annotation = peopleClass.getAnnotation(MyannotationFinall.class);
        System.out.println(annotation.value());

        //获得类指定的注解
        Field name = peopleClass.getDeclaredField("name");
        PropertyAnno annotation1 = name.getAnnotation(PropertyAnno.class);
        System.out.println(annotation1.columnName() + annotation1.type() + annotation1.length());


    }
}


