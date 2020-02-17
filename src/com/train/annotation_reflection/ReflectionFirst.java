package com.train.annotation_reflection;

/**
 * @Time: 20-2-5下午12:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReflectionFirst {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.train.annotation_reflection.ReflectionFirst");
        System.out.println(aClass);
        Class<?> bClass = Class.forName("com.train.annotation_reflection.ReflectionFirst");
        Class<?> cClass = Class.forName("com.train.annotation_reflection.ReflectionFirst");
        // 一个类在内存中只有一个Class
        // 类被加载之后 其整个结构都会封装在Class对象中
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(cClass.hashCode());

        // 获取Class类实例的方法
        // 1. 已知某个类的实例， 通过xxx.geteClass()即可
        User user = new User();
        Class<? extends User> aClass1 = user.getClass();
        // 2. 已知具体的类 通过XXX.class即可
        Class<User> aClass2 = User.class;
        // 3. 已知类的全类名称 通过Class.forName("com.xxx.xx.xx")
        Class<?> aClass3 = Class.forName("com.train.annotation_reflection.User");




    }
}
@MyAnnoSingle("wkk")
class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name= " + name + ", id= "
                + ", age= " + age + "}";
    }
}

