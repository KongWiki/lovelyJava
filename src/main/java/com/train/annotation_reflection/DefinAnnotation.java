package com.train.annotation_reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Time: 20-2-5上午10:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 自定义注解
public class DefinAnnotation {
    @MyAnnoLost
    public static void test(){
        System.out.println("wt");
    }

    public static void main(String[] args) {
        test();
    }
}

/**
 * @Time: 20-2-5上午10:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 * 多参数注解
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnoLost{
    // 定义注解的规则
    // 数据类型: 参数名();
    String name() default "";
    int id() default -1;
    int age() default 0;
    String[] home() default {"杭州", "成都"};
}

/**
 * 单参数注解
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnoSingle{
    String value() ;
}
