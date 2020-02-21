package com.train.annotation_reflection;

import java.lang.annotation.*;

/**
 * @Time: 20-2-5上午10:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */

// 测试元注解
public class MetaAnnotation {
    @MyAnnotation
    public void test() {

    }
}

// 定义一个注解
// 表示注解可以用在什么地方
@Target(ElementType.METHOD)
// 表示注解使用在设么地方
// runtime: 运行时
// class: 编译时
// class: 源码
// runtime ---> class ---> source
@Retention(RetentionPolicy.RUNTIME)
// 表示注解可以生成在JAVAdoc中
@Documented
// 子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}




