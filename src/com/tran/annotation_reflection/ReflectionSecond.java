package com.tran.annotation_reflection;

import java.lang.annotation.ElementType;

/**
 * @Time: 20-2-5下午5:23
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReflectionSecond {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是: " + person.name);

        // 方式一：通过对象获得
        Class<? extends Person> cClass = person.getClass();
        // 方式二：通过类获得
        Class<Student> bClass = Student.class;

        // 方式三： 通过类全名称
        Class<?> aClass = Class.forName("com.tran.annotation_reflection.Student");

        System.out.println("对象获得的class为： " + cClass);
        System.out.println("类获得的class为： "+ bClass);
        System.out.println("类全名称获得的class为： "+ aClass);

        // 方式4: 基本内置类型的包装类都有一个Type属性
        Class<Integer> type = Integer.TYPE;
        System.out.println("内置类型的class为: "+type);

        //获取父类类型
        Class superclass = bClass.getSuperclass();
        System.out.println("获取的父类class为: " + superclass);
        System.out.println(superclass);

        Class a = Object.class;
        Class b = Comparable.class;
        Class c = ElementType.class;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println(System.getProperty("java.class.path"));
        /**
         * /opt/java/jdk1.8.0_191/jre/lib/charsets.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/deploy.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/cldrdata.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/dnsns.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/jaccess.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/jfxrt.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/localedata.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/nashorn.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/sunec.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/sunjce_provider.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/sunpkcs11.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/ext/zipfs.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/javaws.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/jce.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/jfr.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/jfxswt.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/jsse.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/management-agent.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/plugin.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/resources.jar:
         * /opt/java/jdk1.8.0_191/jre/lib/rt.jar:
         * /home/kongweikun/IdeaProjects/JavaTrain/out/production/JavaTrain:
         * /home/kongweikun/Idea/lib/idea_rt.jar
         */

    }
}


