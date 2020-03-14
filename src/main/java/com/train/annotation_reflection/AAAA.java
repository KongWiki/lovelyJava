package com.train.annotation_reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Time: 20-3-10下午6:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AAAA {
    String value() default "";
}
