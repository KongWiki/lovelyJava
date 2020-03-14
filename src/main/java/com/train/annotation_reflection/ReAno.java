package com.train.annotation_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Time: 20-3-10下午6:19
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReAno {
    @AAAA("我是方法注解")
    public void say(int a){
        System.out.println("wtf " + a);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<ReAno> reAnoClass = ReAno.class;
        ReAno reAno = reAnoClass.newInstance();
        Method say = reAnoClass.getDeclaredMethod("say", int.class);
        AAAA annotation = say.getAnnotation(AAAA.class);
        System.out.println(annotation.value());


    }
}
