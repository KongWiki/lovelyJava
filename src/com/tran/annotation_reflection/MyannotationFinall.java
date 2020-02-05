package com.tran.annotation_reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Time: 20-2-5下午10:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
// 类名的注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface  MyannotationFinall {
    String value();
}
