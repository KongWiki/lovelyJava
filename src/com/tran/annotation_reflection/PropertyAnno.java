package com.tran.annotation_reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Time: 20-2-5下午10:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface PropertyAnno {
    String columnName(); // 列名
    String type(); // 数据类型
    int length(); // 长度
}
